package design;

// 900. RLE Iterator

public class RLEIterator {
    // Method: Iterator
    // Time = O(n)
    // Space = O(1)
    int index;
    int[] array;

    public RLEIterator(int[] encoding) {
        index = 0;
        array = encoding;
    }

    public int next(int n) {
        // Exhaust as many terms as possible
        while(index < array.length) {
            // Find the corresponding item
            if (n <= array[index]) {
                // Deduct n from A[index]
                array[index] -= n;
                // Return A[index + 1] as the nth value
                return array[index + 1];
            }
            // Not find the item yet, deduct A[index] from n
            n -= array[index];
            // Move to the next item
            index += 2;
        }
        // Not enough items remain
        return -1;
    }
}
