package com.leetcoder.leetcoder.binaryTree.no297;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:20 下午 2022/1/5
 **/
public class Codec_Post_Solution {
    private static final String SEP = ",";
    private static final String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    private void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        traverse(root.left, sb);
        traverse(root.right, sb);
        sb.append(root.val).append(SEP);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        //这里其实控制的是最后一环
        if (nodes.isEmpty()) return null;

        // 从后往前取出元素
        String last = nodes.removeLast();
        //这里才是真正的return
        if (last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));

        // 限构造右子树，后构造左子树
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }

}
