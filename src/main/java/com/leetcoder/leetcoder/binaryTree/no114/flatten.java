package com.leetcoder.leetcoder.binaryTree.no114;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:49 下午 2021/12/13
 **/
public class flatten {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        //将左子树置空，挂接右子树
        root.left = null;
        root.right = leftNode;

        //找到右子树的最末尾节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = rightNode;
    }
}
