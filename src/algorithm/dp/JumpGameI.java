package algorithm.dp;

/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
Determine if you are able to reach the last index.
*/

public class JumpGameI {
    // Time = O(n^2); Space = O(n)
    public boolean canJump(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        // canJump[i] represents whether can jump to the end from index i
        boolean[] canJump = new boolean[array.length];
        canJump[array.length - 1] = true;  // Base case
        for (int i = array.length - 2; i >= 0; i--) {
            for (int j = 1; j <= array[i]; j++) {
                if (canJump[i + j] == true) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[0];
    }
}
