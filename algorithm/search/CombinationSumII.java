package algorithm.search;

/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
 */

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            helper(result, cur, candidates, target - candidates[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
