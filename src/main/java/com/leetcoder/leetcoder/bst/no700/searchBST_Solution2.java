package com.leetcoder.leetcoder.bst.no700;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:09 下午 2022/1/7
 **/
public class searchBST_Solution2 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
