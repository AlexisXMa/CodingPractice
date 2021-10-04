package design;

// 297. Serialize and Deserialize Binary Tree

import algorithm.tree.TreeNode;
import java.util.*;

public class SerializeDeserializeBTree {
    // Method: BFS

    // Time = O(n); Space = O(n)
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        // NULL elements can be added to LinkedList but not in ArrayDeque
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i  = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    sb.append(cur.key);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else {
                    sb.append("null");
                }
                sb.append(" ");
            }
        }
        return new String(sb);
    }


    // Time = O(n); Space = O(n)
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                for (int j = index; j < index + 2 && j < values.length; j++) {
                    if (values[j].equals("null")) {
                        if (j % 2 == 1) {
                            cur.left = null;
                        } else {
                            cur.right = null;
                        }
                    } else {
                        TreeNode next = new TreeNode(Integer.valueOf(values[j]));
                        queue.offer(next);
                        if (j % 2 == 1) {
                            cur.left = next;
                        } else {
                            cur.right = next;
                        }
                    }
                }
                index += 2;
            }
        }
        return root;
    }
}
