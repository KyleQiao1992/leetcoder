package com.leetcoder.leetcoder.bst.no1305;

import com.leetcoder.leetcoder.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:10 下午 2022/5/1
 **/
public class Solution2 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        traverse(root1, list1);
        traverse(root2, list2);
        return mergeSort(list1, list2);

    }

    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }

    private List<Integer> mergeSort(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        if (list1.isEmpty() && list2.isEmpty()) {
            return res;
        }
        if (list1.isEmpty()) {
            return list2;
        }
        if (list2.isEmpty()) {
            return list1;
        }

        int p = 0;
        int q = 0;

        while (p < list1.size() || q < list2.size()) {
            if (p >= list1.size()) {
                res.add(list2.get(q));
                q++;
                continue;
            }
            if (q >= list2.size()) {
                res.add(list1.get(p));
                p++;
                continue;
            }

            Integer num1 = list1.get(p);
            Integer num2 = list2.get(q);

            if (num1 <= num2) {
                res.add(num1);
                p++;
            } else {
                res.add(num2);
                q++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 f = new Solution2();
        List<Integer> list1 = Arrays.asList(1, 2, 4);
        List<Integer> list2 = Arrays.asList(0, 1, 3, 5);
        List<Integer> res = f.mergeSort(list1, list2);
    }
}
