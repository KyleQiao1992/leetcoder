package com.leetcoder.leetcoder.binaryTree.no222;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 1:29 下午 2022/1/12
 **/
public class countNodes {

    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        Integer hl = 0, hr = 0;

        //计算左子树的高度
        while (l != null) {
            l = l.left;
            hl++;
        }
        //计算右子树的高度
        while (r != null) {
            r = r.right;
            hr++;
        }
        //如果左右子树高度相同
        if (hl.equals(hr)) {
            return (int) (Math.pow(2, hl) - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
