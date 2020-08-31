package org.j.easy;

import org.j.TreeNode;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 226反转二叉树
 * @date 2020-08-31 9:35
 **/
public class InvertBinaryTree226 {
    // java Recursion  Exchange right and left
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;

        // if(root==null)
        //     return root;
        //
        // TreeNode tmpNode = root.left;
        // root.left = invertTree(root.right);
        // root.right = invertTree(tmpNode);
        //
        // return root;

    }

    public void invertTreeHelper(TreeNode root) {
        if (root == null) {
            return;
        } else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTreeHelper(root.left);
            invertTreeHelper(root.right);
        }

    }

    public static void main(String[] args) {

    }
}
