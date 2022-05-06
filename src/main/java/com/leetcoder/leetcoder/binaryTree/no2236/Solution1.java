package com.leetcoder.leetcoder.binaryTree.no2236;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:54 下午 2022/5/6
 **/
public class Solution1 {

    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        return root.val == root.left.val + root.right.val;
    }
}
