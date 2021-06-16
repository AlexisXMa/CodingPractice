package algorithm.dp;

/*
Given an array of non-negative integers, you are initially positioned at index 0 of the array.
A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
Determine the minimum number of jumps you need to jump out of the array.
By jump out, it means you can not stay at the end of the array. Return -1 if you can not do so.
 */

public class JumpGameIII {
    public int minJump(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int n = array.length;
        // At the end of the array, add one more element with value 0,
        // then jump to the end of array.
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = array[i];
        }
        a[n] = 0;
        // minJump[i] represents the min number of jumps from index 0 to index i
        int[] minJump = new int[n + 1];
        minJump[0] = 0;     // Base case
        for (int i = 1; i <= n; i++) {
            minJump[i] = -1;
            for (int j = 0; j <= i - 1; j++) {
                if (j + a[j] >= i && minJump[j] != -1) {
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[n];
    }

}
