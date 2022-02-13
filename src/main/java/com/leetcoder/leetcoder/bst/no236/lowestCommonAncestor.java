package com.leetcoder.leetcoder.bst.no236;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 12:52 下午 2022/1/28
 **/
public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //1: root 等于输入中的任意一个节点 那 根节点就是他们的公共祖先
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //2：如果左右子树都不为空，那root就是他的公共祖先
        if (left != null && right != null) {
            return root;
        }
        //3: 左右子树都不是以root为根节点的公共祖先 返回空
        if (left == null && right == null) {
            return null;
        }
        //4:只有一个节点是在以root为根的树中，函数返回该节点
        return left == null ? right : left;
    }
}
