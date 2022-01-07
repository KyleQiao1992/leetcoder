package com.leetcoder.leetcoder.binaryTree.no230;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:48 下午 2022/1/6
 **/
public class kthSmallest_k_Solution {
    int res = 0;
    int counter = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        counter++;
        if (counter == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
