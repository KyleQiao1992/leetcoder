package com.leetcoder.leetcoder.binaryTree.no437;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:28 下午 2022/5/3
 **/
public class Solution1 {
    public int pathSum(TreeNode root, int sum) {

        if (root == null)
            return 0;

        return findPath(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private int findPath(TreeNode node, int num) {

        if (node == null)
            return 0;

        int res = 0;
        if (node.val == num)
            res += 1;

        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);

        return res;
    }


    public static void main(String[] args) {
        Solution1 f = new Solution1();
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode node = TreeNode.constructTree(nums);
        int res = f.pathSum(node, 22);
    }
}
