package com.leetcoder.leetcoder.bst.no965;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:55 下午 2022/4/29
 **/
public class Solution {


    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traverse(root, root.val);
    }

    private boolean traverse(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return traverse(root.left, val) && traverse(root.right, val);
    }
}
