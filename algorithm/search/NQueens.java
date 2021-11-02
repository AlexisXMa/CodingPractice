package algorithm.search;

/*
Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

Assumptions
N > 0
 */

import java.util.*;

public class NQueens {
    public List<List<Integer>> nQueens(int n) {
        // Method 1: validate the queen position in O(n) each time.
        List<List<Integer>> result = new ArrayList<>();
        // cur will be a list of size n, and cur[i] is the column number
        // where the queen on row i positioned.
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, result);
        return result;
    }

    private void helper(int n, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == n) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            // check if putting a queen at column i at current row is valid
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> cur, int column) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }
}
