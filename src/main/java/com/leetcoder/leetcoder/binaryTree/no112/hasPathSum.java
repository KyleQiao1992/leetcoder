package com.leetcoder.leetcoder.binaryTree.no112;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:19 下午 2021/12/14
 **/
public class hasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        if (hasPathSum(root.left, targetSum - root.val)) {
            return true;
        }
        if (hasPathSum(root.right, targetSum - root.val)) {
            return true;
        }
        return false;
    }

}
