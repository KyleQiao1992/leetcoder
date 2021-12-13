package com.leetcoder.leetcoder.binaryTree.no226;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:12 下午 2021/12/13
 **/
public class invertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
