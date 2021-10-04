package algorithm.dfs;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */

import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(result, cur, n, k, 1);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int n, int k, int num) {
        if (cur.size() == k) {
            result.add(new ArrayList<Integer> (cur));
            return;
        }
        for (int i = num; i <= n; i++) {
            cur.add(i);
            helper(result, cur, n, k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
