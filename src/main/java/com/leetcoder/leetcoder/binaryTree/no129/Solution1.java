package com.leetcoder.leetcoder.binaryTree.no129;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 9:09 下午 2022/5/4
 **/
public class Solution1 {

    private List<String> resList = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, "");
        int res = 0;
        for (String str : resList) {
            res += Integer.parseInt(str);
        }
        return res;
    }

    private void dfs(TreeNode root, String num) {
        if (root == null) {
            return;
        }
        num += root.val;
        if (root.left == null && root.right == null) {
            resList.add(num);
            return;
        }

        dfs(root.left, num);
        dfs(root.right, num);
    }

    public static void main(String[] args) {
        Solution1 f = new Solution1();
        Integer[] tmp = {4, 9, 0, 5, 1};
        TreeNode node = TreeNode.constructTree(tmp);
        f.sumNumbers(node);
    }
}
