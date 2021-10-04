package algorithm.string;

// Find target string in a sorted string array
// Similar Question: Search in an array of strings where non-empty strings are sorted
// https://www.geeksforgeeks.org/search-in-an-array-of-strings-where-non-empty-strings-are-sorted/

public class SearchStringInSortedArray {
    public int search(String[] array, String target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // int cmp = array[mid].compareTo(target);
            int cmp = compareString(array[mid], target);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int compareString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int lenMin = Math.min(len1, len2);

        for (int i = 0; i < lenMin; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                return 0;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            } else {
                return 1;
            }
        }

        if (len1 == len2) {
            return 0;
        }
        return Integer.compare(len1, len2);
    }

    public static void main(String[] args) {
        SearchStringInSortedArray sol = new SearchStringInSortedArray();
        String[] array1 = new String[]{"contribute", "geeks", "ide", "practice" };
        System.out.println(sol.search(array1, "ide"));  // 2
        System.out.println(sol.search(array1, "zz"));   // -1
    }
}
