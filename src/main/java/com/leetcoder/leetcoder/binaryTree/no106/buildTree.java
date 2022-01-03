package com.leetcoder.leetcoder.binaryTree.no106;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:17 下午 2021/12/22
 **/
public class buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] inorder, int inStart, int inEnd,
                         int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        //中序遍历root根节点的位置index
        int inOrderRootIndex = getInOderRootIndex(inorder, inStart, inEnd, postorder[postEnd]);
        //右子树的大小
        int leftSize = inOrderRootIndex - inStart;

        root.left = dfs(inorder, inStart, inOrderRootIndex - 1,
                postorder, postStart, postStart + leftSize - 1);

        root.right = dfs(inorder, inOrderRootIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    //获取中序遍历中 根节点的位置
    private int getInOderRootIndex(int[] inorder, int inStart, int inEnd, int value) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
