package com.leetcoder.leetcoder.bfs.no637;

import com.leetcoder.leetcoder.array.no905.Solution;
import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:40 下午 2022/5/7
 **/
public class Solution1 {

    private List<List<Long>> levelTraverse = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<List<Long>> levelOrder = levelOrderTreeNode(root);

        for (List<Long> list : levelOrder) {
            Long sum = 0L;
            for (Long num : list) {
                sum += num;
            }
            res.add(Double.parseDouble(sum.toString()) / list.size());
        }
        return res;
    }

    private List<List<Long>> levelOrderTreeNode(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Long> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                Integer nodeVal = Integer.valueOf(node.val);
                level.add(Long.parseLong(String.valueOf(nodeVal.longValue())));

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelTraverse.add(level);
        }
        return levelTraverse;
    }

    public static void main(String[] args) {
        Solution1 f = new Solution1();
        Integer[] num = {3, 9, 20, null, null, 15, 7};
        TreeNode node = TreeNode.constructTree(num);
        f.averageOfLevels(node);
    }
}
