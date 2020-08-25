package org.j.medium;

import org.j.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 94给定一个二叉树，返回其节点值的有序遍历。
 * @date 2020-08-25 11:34
 **/
public class BinaryTreeInorderTraversal94 {
    /**
     * 有序遍历二叉树（此时中序）
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        allTreeLDRtoArray(root,list);
        return list;
    }
    public void allTreeLDRtoArray(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null | root.right != null) {
                //有下一节点，不是叶子
                allTreeLDRtoArray(root.left, list);//L
                list.add(root.val);//D
                allTreeLDRtoArray(root.right, list);//R
            } else
                list.add(root.val);//叶子
        }

    }
}
