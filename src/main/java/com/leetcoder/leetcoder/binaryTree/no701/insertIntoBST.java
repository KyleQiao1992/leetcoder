package com.leetcoder.leetcoder.binaryTree.no701;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 1:31 下午 2022/1/10
 **/
public class insertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
