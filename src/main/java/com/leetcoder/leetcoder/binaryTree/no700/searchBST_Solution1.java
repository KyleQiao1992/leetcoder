package com.leetcoder.leetcoder.binaryTree.no700;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:37 下午 2022/1/7
 **/
public class searchBST_Solution1 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        return left == null ? right : left;
    }
}
