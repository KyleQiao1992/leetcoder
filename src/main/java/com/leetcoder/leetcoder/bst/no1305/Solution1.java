package com.leetcoder.leetcoder.bst.no1305;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 11:57 上午 2022/5/1
 **/
public class Solution1 {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        traverse(root1);
        traverse(root2);
        Collections.sort(res);
        return res;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        res.add(node.val);
        traverse(node.right);
    }
}
