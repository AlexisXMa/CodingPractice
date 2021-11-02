package design;

// 384. Shuffle an Array

import java.util.*;

public class ShuffleArray {
    private int[] original;
    private int[] array;
    Random random = new Random();

    public ShuffleArray(int[] nums) {
        this.array = nums;
        this.original = nums.clone();

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            // Get random index j from [i, array.length - 1]
            int j = random.nextInt(array.length - i) + i;
            // Swap array elements at index i and index j
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
