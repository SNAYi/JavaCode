package com.snayi;

import com.snayi.Case;
import com.snayi.annotations.Benchmark;
import com.snayi.annotations.Measurement;
import com.snayi.annotations.WarmUp;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

class CaseRunner{
    private static final int DEFAULT_ITERATIONS=10;
    private static final int DEFAULT_GROUP=5;
    private static final int WARMUP_ITERATIONS=2;
    private final List<Case> caseList;

    public CaseRunner(List<Case> caseList){
        this.caseList=caseList;
    }

    public void run() throws InvocationTargetException, IllegalAccessException {
        for(Case bCase:caseList){
            int iterations=DEFAULT_ITERATIONS;
            int group=DEFAULT_GROUP;
            int warmIterations=WARMUP_ITERATIONS;
            //先获取类级别的配置
            Measurement classMeasurement=bCase.getClass().getAnnotation(Measurement.class);
            if(classMeasurement!=null){
                iterations=classMeasurement.iterators();
                group=classMeasurement.group();
            }
            //找到对象中那些方法是需要测试的方法
            Method[] methods=bCase.getClass().getMethods();
            for(Method method:methods){
                Benchmark benchmark=method.getAnnotation(Benchmark.class);
                if(benchmark==null){
                    continue;
                }
                //获取方法级别的注解
                Measurement methodMeasurement=method.getAnnotation(Measurement.class);
                if(methodMeasurement!=null){
                    iterations=methodMeasurement.iterators();
                    group=methodMeasurement.group();
                }

                runCase(bCase,method,iterations,group,warmIterations);
            }
        }
    }

    @WarmUp(iterators =20)
    private void runCase(Case bCase, Method method, int iterations, int group, int warmIterations) throws
            InvocationTargetException, IllegalAccessException {


        String caseName = bCase.getClass().getName();
        String methodName = method.getName();
        System.out.println(caseName+"的"+methodName+"方法"+" 的测试报告如下：");

        //预热检测部分
        if(warmIterations != 0) {
            System.out.println("-----------------------------------------------------");
            System.out.println("预热开始..........");
            for(int k=0; k<warmIterations; k++) {
                System.out.print("第 "+(k+1)+" 次预热：");
                long timeStart = System.nanoTime();
                //每个预热单位默认执行50次
                for(int m=0; m<100;m++) {
                    method.invoke(bCase);
                }
                long timeEnd = System.nanoTime();
                long time = timeEnd - timeStart;
                System.out.println("耗时："+time/100);
            }
            System.out.println("预热完毕..........");
            System.out.println("-----------------------------------------------------");
        }

        //真正的测试，调用对象的测试实例方法
        for (int i = 0;i < group;i++){
            System.out.printf("第 %d 次实验，",i+1);
            long t1 = System.nanoTime();
            for (int j = 0;j < iterations;j++){
                method.invoke(bCase);
            }
            long t2 = System.nanoTime();
            System.out.printf("耗时 %d 纳秒 %n",t2 - t1);
        }
    }
}

//测试用例加载
// 1.根据一个固定类，找到类加载器
// 2.根据加载器找到类文件所在的路径
// 3.扫描路径的所有类文件
public class CaseLoader{
    public CaseRunner load() throws IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException {

        String st="com.snayi.cases";
        String str="com/snayi/cases";

        List<String> classNameList=new ArrayList<String>();
        ClassLoader classLoader=this.getClass().getClassLoader();
        Enumeration<URL> urls=classLoader.getResources(str);

        while(urls.hasMoreElements()) {//遍历路径下所有的文件
            URL url = urls.nextElement( );
            if(!url.getProtocol().equals("file")){
                //如果不是*.class文件,暂时不支持
                continue;
            }

            String dirname=URLDecoder.decode(url.getPath(),"UTF-8");
            File dir=new File(dirname);
            if(!dir.isDirectory()){
                //不是目录
                continue;
            }
            //扫描该目录下的所有*.class文件，作为所有的类文件
            File[] files=dir.listFiles();
            if(files==null){
                continue;
            }

            for(File file:files){
                String fileName=file.getName();
                String className=fileName.substring(0,fileName.length()-6);
                classNameList.add(className);
            }
        }
        List<Case> casesList=new ArrayList<Case>();
        for(String className: classNameList){
            Object cls=Class.forName(st+"."+className);
            if(hashInterface((Class<?>) cls,Case.class)){
                casesList.add((Case)((Class) cls).newInstance());

            }
        }
        return new CaseRunner(casesList);
    }
    private boolean hashInterface(Class<?>cls,Class<?> intf){
        Class<?>[] intfs=cls.getInterfaces();
        for(Class<?> i:intfs){
            if(i==intf){
                return true;
            }
        }
        return false;
    }
}
