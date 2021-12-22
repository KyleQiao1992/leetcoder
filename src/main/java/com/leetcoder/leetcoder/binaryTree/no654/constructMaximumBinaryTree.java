package com.leetcoder.leetcoder.binaryTree.no654;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 10:43 下午 2021/12/19
 **/
public class constructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        Integer maxIndex = getMaxIndexFromRangArray(nums, start, end);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = dfs(nums, start, maxIndex - 1);
        node.right = dfs(nums, maxIndex + 1, end);
        return node;
    }

    //key array:index
    private Integer getMaxIndexFromRangArray(int[] nums, int start, int end) {
        Integer maxIndex = start;
        Integer maxValue = nums[start];
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{3, 2, 1, 6, 0, 5};
        constructMaximumBinaryTree f = new constructMaximumBinaryTree();
        f.constructMaximumBinaryTree(testArray);
    }
}
