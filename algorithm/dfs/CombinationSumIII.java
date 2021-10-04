package algorithm.dfs;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
 */

import java.util.*;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(result, cur, k, n, 1);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int k, int n, int index) {
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<Integer>(cur));
                return;
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            cur.add(i);
            helper(result, cur, k - 1, n - i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
