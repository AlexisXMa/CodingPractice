package algorithm.array;

public class MedianOfTwoSortedArrays {
    public double median(int[] a, int[] b) {
        int totalLen = a.length + b.length;
        if (totalLen % 2 == 1) {
            return (double) kth(a, b, 1 + totalLen / 2) != -1 ? a[kth(a, b, 1 + totalLen / 2)] : b[kth(b, a, 1 + totalLen / 2)];
        } else {
            int med1 = kth(a, b, totalLen / 2) != -1 ?
                    a[kth(a, b, totalLen / 2)] : b[kth(b, a, totalLen / 2)];
            int med2 = kth(a, b, 1 + totalLen / 2) != -1 ?
                    a[kth(a, b, 1 + totalLen / 2)] : b[kth(b, a, 1 + totalLen / 2)];
            return (double)(med1 + med2) / 2;
        }
    }

    // return index of kth smallest element in a
    private int kth(int[] a, int[] b, int k) {
        int left = 0;
        int right = Math.min(a.length - 1, k - 1);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < readIndex(b, k - mid - 2)) {
                // a[mid] is not large enough
                left = mid + 1;
            } else if (a[mid] > readIndex(b, k - mid - 1)) {
                // a[mid] is not small enough
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int readIndex(int[] array, int index) {
        if (index < 0) {
            return Integer.MIN_VALUE;
        } else if (index >= array.length) {
            return Integer.MAX_VALUE;
        }
        return array[index];
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        int[] arr1 = new int[]{1,2,3,4,7,9};
        int[] arr2 = new int[]{};
        System.out.println(sol.median(arr1, arr2));
    }
}
