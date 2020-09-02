package org.j.medium;

import org.j.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 230给定二叉搜索树，编写一个函数kthSmallest以在其中找到第k个最小元素。
 * @date 2020-09-01 14:56
 **/
public class KthSmallestElementIn_a_BST230 {
    // public static int kthSmallest(TreeNode root, int k) {
    //     List<Integer> list = new ArrayList<>();
    //     treeLDR(root, k, list);
    //     return list.get(k - 1);
    // }
    //
    // public static int treeLDR(TreeNode root, int k, List<Integer> list) {
    //     if (list.size() == k) {
    //         return 0;
    //     }
    //     if (root != null) {
    //         if (treeLDR(root.left, k, list) == 0)//L
    //             return 0;
    //         list.add(root.val);//D
    //         if (list.size() == k)
    //             return 0;
    //         if (treeLDR(root.right, k, list) == 0)//R
    //             return 0;
    //     }
    //     return 1;
    // }

    // Member variables更优
    public static int kthSmallest(TreeNode root, int k) {

        TreeNode node = new TreeNode(0);
        treeLDR(root, k, node);
        return node.val;
    }

    public static int treeLDR(TreeNode root, int k, TreeNode node) {
        if (node.val == k) {
            return 0;
        }
        if (root != null) {

            if (treeLDR(root.left, k, node) == 0)//L
                return 0;
            node.val++;
            if (node.val == k) {
                node.val = root.val;
                return 0;
            }
            if (treeLDR(root.right, k, node) == 0)//R
                return 0;
        }
        return 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(1);
        root.left.left = new TreeNode(2);

        System.out.println();
        System.out.println(kthSmallest(root, 6));
    }
}
