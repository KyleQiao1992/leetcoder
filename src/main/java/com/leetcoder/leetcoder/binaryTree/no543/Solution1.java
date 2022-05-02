package com.leetcoder.leetcoder.binaryTree.no543;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 9:22 下午 2022/5/1
 **/
public class Solution1 {


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int res = leftMax + rightMax;
        return Math.max(res,
                Math.max(diameterOfBinaryTree(root.left),
                        diameterOfBinaryTree(root.right)));
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = maxDepth(node.left);
        int rightMax = maxDepth(node.right);
        return Math.max(leftMax, rightMax) + 1;
    }

}
