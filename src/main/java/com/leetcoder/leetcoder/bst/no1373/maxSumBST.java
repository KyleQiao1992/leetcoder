package com.leetcoder.leetcoder.bst.no1373;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:15 下午 2022/1/15
 **/
public class maxSumBST {
    // 最大键值和
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    /**
     * 后序遍历节点，并返回以下值：
     * res[0] 记录以root为根的二叉树是否是BST，若为1则为BST、0则不是BST；
     * res[1] 记录以root为根的二叉树所有节点中的最小值；
     * res[2] 记录以root为根的二叉树所有节点中的最大值；
     * res[3] 记录以root为根的二叉树所有节点键值和。
     */
    private int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        // 递归遍历计算左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        // 判断以当前节点为根节点的子树是否为BFS，并更新值
        int[] res = new int[4];
        if (isBFS(root, left, right)) {
            // 填充返回值:
            // 1、标记为BFS
            res[0] = 1;
            // 2、计算最小值
            res[1] = Math.min(root.val, left[1]);
            // 3、计算最大值
            res[2] = Math.max(root.val, right[2]);
            // 4、计算键值和
            res[3] = left[3] + right[3] + root.val;

            // 更新全局最大键值和
            maxSum = Math.max(maxSum, res[3]);
        }

        return res;
    }

    /**
     * 判断以当前节点为根节点的子树是否为BFS
     */
    private boolean isBFS(TreeNode root, int[] left, int[] right) {
        boolean res = false;
        // 是BFS的条件如下：
        // 1、左右子树均为BFS；
        // 2、根节点值大于左子树的最大值；
        // 3、根节点值小于右子树的最小值。
        if (left[0] == 1 && right[0] == 1
                && root.val > left[2]
                && root.val < right[1]) {
            return true;
        }
        return res;
    }
}
