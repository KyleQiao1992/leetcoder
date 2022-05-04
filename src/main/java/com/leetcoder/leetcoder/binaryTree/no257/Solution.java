package com.leetcoder.leetcoder.binaryTree.no257;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:04 下午 2022/5/3
 **/
public class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private String dfs(TreeNode node, String str) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            str += node.val;
            res.add(str);
        }

        str += node.val + "->";
        dfs(node.left, str);
        dfs(node.right, str);
        return str;
    }

    public static void main(String[] args) {
        Solution f = new Solution();
        Integer[] num = {1};
        TreeNode treeNode = TreeNode.constructTree(num);
        f.binaryTreePaths(treeNode);
    }
}
