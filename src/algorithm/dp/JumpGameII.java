package algorithm.dp;

/*
Given an array A of non-negative integers, you are initially positioned at index 0
of the array. A[i] means the maximum jump distance from index i (you can only jump
towards the end of the array). Determine the minimum number of jumps you need to
reach the end of array. If you can not reach the end of the array, return -1.
 */

public class JumpGameII {
    // Time = O(n^2); Space = O(n)
    public int minJump(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        // minJump[i] represents the min number of jumps from index 0 to index i
        int[] minJump = new int[array.length];
        minJump[0] = 0;     // Base case
        for (int i = 1; i < array.length; i++) {
            minJump[i] = -1;
            for (int j = 0; j <= i - 1; j++) {
                if (j + array[j] >= i && minJump[j] != -1) {
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[array.length - 1];
    }
}
