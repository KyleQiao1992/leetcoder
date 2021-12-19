package com.leetcoder.leetcoder.binaryTree.no94;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:52 下午 2021/12/19
 **/
public class inorderTraversal {
    public List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}
