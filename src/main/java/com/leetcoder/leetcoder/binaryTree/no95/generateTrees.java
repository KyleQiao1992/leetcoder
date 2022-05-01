package com.leetcoder.leetcoder.binaryTree.no95;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:54 下午 2022/1/11
 **/
public class generateTrees {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n == 0) {
            return res;
        }
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        if (low > high) {
            res.add(null);
            return res;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTree = dfs(low, i - 1);
            List<TreeNode> rightTree = dfs(i + 1, high);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
