package com.leetcoder.leetcoder.binaryTree.no543;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:19 下午 2022/5/2
 **/
public class Solution2 {

    public int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    //这里注意计算的是depth
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        int maxSum = leftMax + rightMax;
        maxDiameter = Math.max(maxSum, maxDiameter);
        return Math.max(leftMax, rightMax) + 1;
    }
}
