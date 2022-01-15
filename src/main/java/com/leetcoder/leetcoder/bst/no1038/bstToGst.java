package com.leetcoder.leetcoder.bst.no1038;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 6:06 下午 2022/1/14
 **/
public class bstToGst {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root.right);

        sum += root.val;
        root.val = sum;

        dfs(root.left);

        return root;
    }
}
