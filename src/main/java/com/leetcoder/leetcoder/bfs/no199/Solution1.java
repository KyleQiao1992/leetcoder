package com.leetcoder.leetcoder.bfs.no199;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:42 下午 2022/5/8
 **/
public class Solution1 {

    private List<List<Integer>> levelOrder = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<List<Integer>> levelOrder = getLevelOrder(root);

        for (List<Integer> list : levelOrder) {
            res.add(list.get(list.size() - 1));
        }

        return res;
    }

    private List<List<Integer>> getLevelOrder(TreeNode root) {
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelOrder.add(level);
        }
        return levelOrder;
    }

    public static void main(String[] args) {
        Solution1 f = new Solution1();
        Integer[] nums = {1, 2, 3, null, 5, null, 4};
        TreeNode node = TreeNode.constructTree(nums);
        f.rightSideView(node);
    }
}
