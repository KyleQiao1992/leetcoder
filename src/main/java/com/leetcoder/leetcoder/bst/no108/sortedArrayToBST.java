package com.leetcoder.leetcoder.bst.no108;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:40 下午 2022/4/19
 **/
public class sortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int midIndex = (startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);

        root.left = helper(nums, startIndex, midIndex - 1);
        root.right = helper(nums, midIndex + 1, endIndex);
        return root;
    }

    public static void main(String[] args) {
        sortedArrayToBST f = new sortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode t = f.sortedArrayToBST(nums);
    }
}
