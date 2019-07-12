public class NumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }
        int firstIndex = getFirstIndex(array, k);
        int lastIndex = getLastIndex(array, k);
        return lastIndex - firstIndex + 1;
    }
    private int getFirstIndex(int[] array, int k) {
        int start = 0, end = array.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return start;
    }
    private int getLastIndex(int[] array, int k) {
        int start = 0, end = array.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (array[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return end;
    }
}