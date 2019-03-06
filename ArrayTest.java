public class ArrayTest {
	 //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
		//1.如果数组长度是0，则下标越界
		//2.如果data是null，一定要进行参数校验
		//参数校验可以保证程序更加健壮
         int max = data[0];
		 for(int i = 1; i < data.length;i++) {
			 if(max < data[i]) {
				 max = data[i];
			 }
		 }
        return max;
    }
    
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
         int min = data[7];
		 for(int i = 0; i < data.length;i++) {
			 if(min > data[i]) {
				 min = data[i];
			 }
		 }
        return min;
    }
    
    
    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        int sum = data[0];
		for(int i = 1; i <data.length;i++) {
			sum = sum +data[i];
		}
        return sum;
    }
    
    //4.数组拼接
    public static int[] arrayJoin(int[] a, int[] b){
        //a = new int[100];
		//b = new int[20];
		int[] c = new int[a.length + b.length];
		System.arraycopy(a,0,c,0,a.length);
		System.arraycopy(b,0,c,a.length,b.length);
        return c;
    }

    //5.数组截取
    //[start, end)
	//[3, 6) => 3 => end-start 
    public static int[] arraySub(int[] data, int start , int end){
        //TODO
		int length = end - start;
		int[] array = new int[length];
		int j = 0;
		for(int i = start; i < end; i++) {
			array[j] = data[i];
			j++;
		}
        return array;
    }
    
    //6.数组打印  4,3,2,1
    public static void printArray(int[] data){
        for(int i = 0;i < data.length;i++) {
			System.out.print(data[i]);
			if(i <(data.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println();
    }
    
    //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
        int left = 0;
		int right = data.length - 1;
		while(left < right) {
			int temp = data[left];
			data[left] = data[right];
			data[right] = temp;
			left++;
			right--;
		}
		//另一种写法,更优化
		//参数校验如果给null,不通过
		/*if(data = null) {
			return;
		}
		int mid =data.length / 2;
		foa(int i = 0;i < mid; i++) {
			int temp = data[i];
			data[i] = data[data.length - 1 - i];
			data[data.length - 1 - i] = temp;
		} */
    }
    
    public static void main(String[] args){
        int[] data1 = new int[]{2,1,3,4,8,5,6,7};
		int[] data2 = new int[]{11,12,13,14};
		System.out.println("数组最大值是：" + arrayMaxElement(data1));
		System.out.println("数组最小值是：" + arrayMinElement(data1));
		System.out.println("数组值之和是：" + arrayElementSum(data1));
		
		System.out.println("打印数组：");
		printArray(data1);
		
		System.out.println("反转后的数组：");
		printReversal(data1);
		printArray(data1);
		
		int[] data3 =new int[1024];
		System.out.println("拼接后的数组：");
		 data3 = arrayJoin(data1,data2);
		printArray(data3);
		
		System.out.println("截取后的数组：");
		data3 = arraySub(data1,2,6);
		printArray(data3);
    }
}