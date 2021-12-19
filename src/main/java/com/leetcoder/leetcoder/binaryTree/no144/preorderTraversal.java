package com.leetcoder.leetcoder.binaryTree.no144;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:33 下午 2021/12/19
 **/
public class preorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
