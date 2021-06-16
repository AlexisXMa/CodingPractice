package algorithm.dfs;

/*
Given an integer number, return all possible combinations of the factors that can multiply to the target number.
 */

import java.util.*;

public class FactorCombinations {
    // Method: consider one factor at each level
    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 1) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getFactors(target);
        helper(result, cur, factors, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, List<Integer> factors,
                        int target, int index) {
        if (target == 1) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        if (index == factors.size()) {
            return;
        }
        // not pick any of the factor at current level
        helper(result, cur, factors, target, index + 1);
        int factor = factors.get(index);
        int size = cur.size();
        // pick 1, ..., n of the factor at current level
        while (target % factor == 0) {
            cur.add(factor);
            target /= factor;
            helper(result, cur, factors, target, index + 1);
        }
        cur.subList(size, cur.size()).clear();
    }

    private List<Integer> getFactors(int target) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= target / 2; i++) {
            if (target % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}
