public class TestInsertSort {
	public static void insertSort(int[] array) {
	int temp = 0;
	for (int i = 1; i < array.length; i++) {
		temp = array[i];
		int j = 0;
		for (j= i - 1; j >= 0; j--) {
			//考虑到了相等的情况
			if (array[j]> temp) {
				array[j + 1] = array[j];
			} else {
				break;
			}
		}
		array[j + 1] = temp;
	}
	}
	public static void main(String[] args) {
        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000) + 1;
        }
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
