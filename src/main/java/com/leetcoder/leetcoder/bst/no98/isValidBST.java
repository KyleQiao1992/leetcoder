package com.leetcoder.leetcoder.bst.no98;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 5:52 下午 2022/1/7
 **/
public class isValidBST {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private Boolean dfs(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // root.val max min BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // root.val root.val
        return dfs(root.left, min, root)
                && dfs(root.right, root, max);
    }
}
