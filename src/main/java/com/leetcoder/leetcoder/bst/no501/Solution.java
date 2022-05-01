package com.leetcoder.leetcoder.bst.no501;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.*;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:10 下午 2022/5/1
 **/
public class Solution {

    Map<Integer, Integer> frequencyMap = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root);

        Integer max = 0;
        for (Integer key : frequencyMap.keySet()) {
            max = Math.max(max, frequencyMap.get(key));
        }
        List<Integer> resList = new ArrayList<>();
        for (Integer key : frequencyMap.keySet()) {
            if (max.equals(frequencyMap.get(key))) {
                resList.add(key);
            }
        }
        int[] res = new int[resList.size()];
        int i = 0;
        for (Integer num : resList) {
            res[i] = num;
            i++;
        }
        return res;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        if (frequencyMap.containsKey(node.val)) {
            Integer value = frequencyMap.get(node.val);
            frequencyMap.put(node.val, ++value);
        } else {
            frequencyMap.put(node.val, 1);
        }
        traverse(node.left);
        traverse(node.right);
    }

    public static void main(String[] args) {
        Solution f = new Solution();
        Integer[] array = {1, null, 2, 3};
        TreeNode node = TreeNode.constructTree(array);
        f.findMode(node);
    }
}
