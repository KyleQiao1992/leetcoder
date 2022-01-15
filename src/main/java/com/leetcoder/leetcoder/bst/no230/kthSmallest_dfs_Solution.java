package com.leetcoder.leetcoder.bst.no230;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:36 下午 2022/1/6
 **/
public class kthSmallest_dfs_Solution {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> dfsList) {
        if (root == null) {
            return;
        }
        dfs(root.left, dfsList);
        dfsList.add(root.val);
        dfs(root.right, dfsList);
    }
}
