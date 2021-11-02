package algorithm.tree;

// 652. Find Duplicate Subtrees

import java.util.*;

public class FindDuplicateSubtrees {
    // Method 1: Tree Serialization + HashMap
    // Time = O(n^2); Space = O(n^2)
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        postorder(root, map, result);
        return result;
    }

    private String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> result) {
        if (cur == null) {
            return "#";
        }
        String serial = cur.key + "," + postorder(cur.left, map, result) + "," + postorder(cur.right, map, result);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) ==2) {
            result.add(cur);
        }
        return serial;
    }


    // Method 1: Tree Serialization + HashMap with ids
    // Time = O(n); Space = O(n)

    int curId = 1;

    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> idMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        postorder(root, idMap, countMap, result);
        return result;
    }

    private int postorder(TreeNode cur, Map<String, Integer> idMap, Map<Integer, Integer> countMap, List<TreeNode> result) {
        if (cur == null) {
            return 0;
        }
        int leftId = postorder(cur.left, idMap, countMap, result);
        int rightId = postorder(cur.right, idMap, countMap, result);
        String serial = cur.key + "," + leftId + "," + rightId;
        Integer serialId = idMap.get(serial);
        if (serialId == null) {
            serialId = curId;
            idMap.put(serial, curId++);
        }
        countMap.put(serialId, countMap.getOrDefault(serialId, 0) + 1);
        if (countMap.get(serialId) ==2) {
            result.add(cur);
        }
        return serialId;
    }
}
