package com.leetcoder.leetcoder.binaryTree.no113;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:04 下午 2022/5/6
 **/
public class Solution1 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        traverse(root, sum, new LinkedList<>());
        return res;
    }

    // 遍历二叉树
    private void traverse(TreeNode root, int sum, LinkedList<Integer> path) {
        if (root == null) return;

        int remain = sum - root.val;

        if (root.left == null && root.right == null) {
            if (remain == 0) {
                // 找到一条路径
                path.addLast(root.val);
                res.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }

        // 维护路径列表
        path.addLast(root.val);
        traverse(root.left, remain, path);
        path.removeLast();

        path.addLast(root.val);
        traverse(root.right, remain, path);
        path.removeLast();
    }


    public static void main(String[] args) {
        Solution1 f = new Solution1();
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode treeNode = TreeNode.constructTree(nums);
        f.pathSum(treeNode, 22);
    }
}
