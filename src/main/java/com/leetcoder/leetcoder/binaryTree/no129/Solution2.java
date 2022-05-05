package com.leetcoder.leetcoder.binaryTree.no129;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 9:23 下午 2022/5/4
 **/
public class Solution2 {

    private Integer sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, Integer preNum) {
        if (root == null) {
            return;
        }

        preNum = preNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += preNum;
        }
        dfs(root.left, preNum);
        dfs(root.right, preNum);
    }
}
