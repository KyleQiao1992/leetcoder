package com.leetcoder.leetcoder.binaryTree.no100;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:30 下午 2021/12/19
 **/
public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

}
