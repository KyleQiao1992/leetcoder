package com.leetcoder.leetcoder.bfs.no102;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:08 下午 2022/1/6
 **/
public class levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //while 控制从上到下一层一层遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();

            //for 控制每一层从左到右遍历
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        levelOrder f = new levelOrder();
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode node = TreeNode.constructTree(nums);
        f.levelOrder(node);
    }
}
