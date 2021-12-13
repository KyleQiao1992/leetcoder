package com.leetcoder.leetcoder.binaryTree;

/**
 * @ Description : 计算二叉树有多少个节点
 * @ wiki:
 * @ date: created in 6:50 下午 2021/12/13
 **/
public class BTCount {

    public Integer count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}
