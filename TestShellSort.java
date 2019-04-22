public class TestShellSort {
    public static  void shell(int[] array,int gap) {
        int temp = 0;
        for (int i = gap; i < array.length; i++) {
            temp = array[i];
            int j = 0;
            for (j = i - gap; j >= 0; j -= gap) {
                if (array[j] > temp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j+ gap] = temp;

        }
    }
    public static void shellSort(int[] array) {
        int [] drr = {5,3,1};
        for (int i = 0; i < array.length; i++) {
            shell(array,drr[i]);
        }

    }
	public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
