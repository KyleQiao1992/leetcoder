package com.leetcoder.leetcoder.binaryTree.no105;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 11:14 上午 2021/12/22
 **/
public class buildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inOrderRootIndex = findInOrderArrayRootIndex(inorder, inStart, inEnd, preorder[preStart]);
        int leftTreeSize = inOrderRootIndex - inStart;

        root.left = dfs(preorder, preStart + 1, preStart + leftTreeSize,
                inorder, inStart, inOrderRootIndex - 1);
        root.right = dfs(preorder, preStart + leftTreeSize + 1, preEnd,
                inorder, inOrderRootIndex + 1, inEnd);
        return root;
    }

    //找打中序遍历的根节点所在位置
    private int findInOrderArrayRootIndex(int[] inorder, int il, int ir, int value) {
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
