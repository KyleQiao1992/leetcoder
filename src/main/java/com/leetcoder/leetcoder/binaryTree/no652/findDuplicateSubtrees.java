package com.leetcoder.leetcoder.binaryTree.no652;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 5:01 下午 2021/12/23
 **/
public class findDuplicateSubtrees {

    Map<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftSubTree = traverse(root.left);
        String rightSubTree = traverse(root.right);
        String tree = leftSubTree + "," + rightSubTree + "," + root.val;

        int freq = memo.getOrDefault(tree, 0);
        if (freq == 1) {
            res.add(root);
        }
        memo.put(tree, freq + 1);
        return tree;
    }
}
