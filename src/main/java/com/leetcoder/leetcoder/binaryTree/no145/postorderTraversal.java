package com.leetcoder.leetcoder.binaryTree.no145;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:58 下午 2021/12/19
 **/
public class postorderTraversal {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
}
