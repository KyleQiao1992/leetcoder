package com.leetcoder.leetcoder.binaryTree.no538;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:07 下午 2022/1/7
 **/
public class convertBST {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode originTree) {
        if (originTree == null) {
            return;
        }

        dfs(originTree.right);
        sum += originTree.val;
        originTree.val = sum;
        dfs(originTree.left);
    }
}
