package com.leetcoder.leetcoder.binaryTree.no116;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:41 下午 2021/12/13
 **/
public class connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        helper(root.left, root.right);
        return root;
    }

    private void helper(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        helper(node1.left, node1.right);
        helper(node2.left, node2.right);
        helper(node1.right, node2.left);
    }


    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
