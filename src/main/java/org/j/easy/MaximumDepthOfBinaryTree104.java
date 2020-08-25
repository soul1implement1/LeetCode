package org.j.easy;

import org.j.TreeNode;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 104给定二叉树，找到其最大深度。 最大深度是沿着从根节点到最远叶节点的最长路径的节点数。关联617题
 * @date 2020-08-24 15:40
 **/
public class MaximumDepthOfBinaryTree104 {
    //617工具
    public static MergeTwoBinaryTrees617 treeTool = new MergeTwoBinaryTrees617();

    /**
     * 寻找二叉树深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root != null) {
            // 找分支
            left += maxDepth(root.left);
            right += maxDepth(root.right);
            // 找最深的一个分支
            if (left >= right) {
                return left + 1;
            } else {
                return right + 1;
            }
        } else {
            // 此分支无下一层
            return 0;
        }
    }

    public static void main(String[] args) {
        // 构造二叉树
        TreeNode root1 = treeTool.inputTree(1);
        maxDepth(root1);
        treeTool.closeScanner();
    }
}
