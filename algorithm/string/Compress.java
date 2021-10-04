package algorithm.string;

public class Compress {
    public String compress(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        return encode(array);
    }

    private String encode(char[] array) {
        int slow = 0, fast = 0;
        while (fast < array.length) {
            int begin = fast;
            while (fast < array.length && array[begin] == array[fast]) {
                fast++;
            }
            array[slow++] = array[begin];
            if (fast - begin > 1) {
                int len = (fast - begin);
                array[slow++] = (char)('0' + len);
            }
        }
        return new String(array, 0, slow);
    }

    public static void main (String[] args) {
        Compress sol = new Compress();
        System.out.println(sol.compress("abbcccdeee")); // expected “ab2c3de3”
    }
}
