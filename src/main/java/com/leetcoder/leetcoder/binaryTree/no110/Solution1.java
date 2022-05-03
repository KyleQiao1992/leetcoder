package com.leetcoder.leetcoder.binaryTree.no110;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:27 下午 2022/5/3
 **/
public class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}
