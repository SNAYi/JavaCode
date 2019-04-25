public class TestReflect {
    public static void main(String[] args) throws Exception {
        String str = "emp.name:snayi|emp.job:Coder";
        EmpAction empAction =new EmpAction();
        empAction.setEmpValue(str);
        System.out.println(empAction.getEmp());
    }
}
public class Emp {
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

public class EmpAction {
    private Emp emp = new Emp();
    public void setEmpValue(String str) throws Exception {
        BeanUtil.setBeanValue(this,str);
    }
    public Emp getEmp() {
        return this.emp;
    }
}

 * 操作简单类属性设置的工具类
 * @auther deng
 * @date 2019/4/24 下午 05:29
 
public class BeanUtil {
    private BeanUtil() {
    }
    /**
     * actionObj：拿到提供给用户使用的XXAction类
     * beanValue：要设置的具体值
     * emp.name:snayi|emp.job:Coder
     */
    public  static void setBeanValue(Object actionObj,String beanValue) throws
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //1.先将字符串拆分出来得到想要的值
        //emp.name:snayi
        String[] temp = beanValue.split("\\|");
        Object realObject = null;
        for (int i = 0; i < temp.length; i++) {
            //emp.name
            // snayi
            String[] result = temp[i].split(":");
            // snayi
            String realValue = result[1];
            //emp
            String className = result[0].split("\\.")[0];
            //name
            String attrName = result[0].split("\\.")[1];
            realObject = getRealObject(actionObj,className);

            //调用真正的setter方法设置属性值
            //取得真正主题类的class对象
            Class<?> cls = realObject.getClass();
            //拼装setter方法名
            String setName = "set" + initCap(attrName);
            //取得setter方法的method对象
            Method setMethod = cls.getMethod(setName,String.class);
            //调用invoke通过反射设置值
            setMethod.invoke(realObject,realValue);
        }
    }
    //2.根据XXAction类取得真正要操作的类XX
    //通过反射调用getXX()
    private static Object getRealObject(Object actionObj,String className)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //(1)取得XXAction的 Class对象
        Class<?> cls = actionObj.getClass();
        //(2)拼装getXX()方法名称
        String methodName = "get" + initCap(className);
        //(3)取的该方法名称的Method对象
        Method method = cls.getMethod(methodName);
        //(4)通过反射调用该方法
        //等同于empAction.getEmp();
        return method.invoke(actionObj);

    }

    private static String initCap(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}

