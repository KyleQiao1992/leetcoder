package com.leetcoder.leetcoder.binaryTree.nolcp44;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:30 下午 2022/5/7
 **/
public class Solution1 {

    private Set<Integer> set = new HashSet<>();

    public int numColor(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return set.size();
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
