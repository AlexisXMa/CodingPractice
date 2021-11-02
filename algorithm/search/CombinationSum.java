package algorithm.search;

/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to the target.
The same repeated number may be chosen unlimited number of times.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
 */

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(result, cur, candidates, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(result, cur, candidates, target - candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
