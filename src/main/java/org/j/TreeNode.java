package org.j;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 二叉树
 * @date 2020-08-24 15:42
 **/
public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
