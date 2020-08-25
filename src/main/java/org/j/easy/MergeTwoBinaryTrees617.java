package org.j.easy;

import org.j.TreeNode;

import java.util.*;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 617合并两个二叉树；给定两棵二叉树，想象一下，当您将其中一棵树覆盖另一棵树时，两棵树的某些节点是重叠的，而其他树却没有。
 * 您需要将它们合并到新的二叉树中。合并规则是，如果两个节点重叠，则将节点值加起来作为合并节点的新值。否则，NOT空节点将用作新树的节点。
 * @date 2020-08-17 11:20
 **/
public class MergeTwoBinaryTrees617 {
    //树输入
    Scanner scanner = new Scanner(System.in);
    //层级遍历队列
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //二叉树最大层，直接输入
    Integer lay = 1;

    /**
     * 合并二叉树
     *
     * @param tree1
     * @param tree2
     * @return
     */
    public void mergeTrees(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null | tree2 == null) {
            try {
                throw new Exception("不允许空树");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 存入先序遍历，两树层数相同，才能输出正确结果，更优法，使用队列进行层次遍历,存层级结果
        List<Integer> list1 = new LinkedList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();


        //测试
        // test(list1, list2);

        // // 同层级，先序遍历，非完全解法
        // // allTreeLDRtoArray(tree1,list1);
        // // allTreeLDRtoArray(tree2,list2);
        // // 不完全解法1
        // // printResult(list1,list2,"新树先序遍历输出：");
        // 完全解法2

        //树一的层级遍历
        queue.add(tree1);
        allTreeLayToArray(list1,1);
        //树二的层级遍历
        queue.add(tree2);
        allTreeLayToArray(list2,1);

        printResult(list1, list2, "新树层级遍历输出（含null,可转为树）：");
    }


    /**
     * 输出新树
     *
     * @param list1
     * @param list2
     * @param string
     */
    public void printResult(List<Integer> list1, List<Integer> list2, String string) {
        //处理(去掉)lay+1的null,减2n次方-1
        list1=list1.subList(0, (int) Math.pow(2,lay+1)-1);
        list2=list2.subList(0, (int) Math.pow(2,lay+1)-1);

        //判断，值得使用,得到新树的完全先序遍历list1（层级遍历，同样要此步骤）
        for (int i = 0; i < list1.size(); i++) {
            Integer l1 = list1.get(i);
            Integer l2 = list2.get(i);
            if (l1 == null) {
                if (l2 != null)
                    list1.set(i, l2);
            } else {
                if (l2 != null)
                    list1.set(i, l2 + l1);
            }

        }
        //输出解法的树的遍历结果
        System.out.println(string);
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != null) {
                System.out.print("--" + list1.get(i));
            }
        }
        System.out.println();
        System.out.println();
    }

    public void test(List<Integer> list1, List<Integer> list2) {
        // --1--2--3--7--1--3--1--8
        //         --6--7--8--2--3
        list1.add(5);
        list1.add(3);
        list1.add(null);
        list1.add(1);
        list1.add(null);
        list1.add(2);
        list1.add(null);

        list2.add(null);
        list2.add(1);
        list2.add(4);
        list2.add(2);
        list2.add(null);
        list2.add(3);
        list2.add(7);

        // List<Integer> list = new LinkedList<Integer>();
        // treeTool.queue.add(root1);
        // treeTool.allTreeLayToArray(list, 1);
        // System.out.println(list.size());
        // for (int i=0;i<list.size();i++)
        //     System.out.print(list.get(i)+"--");

    }

    /**
     * 先序保存完全二叉树；小了用LinkedList,大了使用文件
     *
     * @param root
     * @param list
     */
    public void allTreeLDRtoArray(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null | root.right != null) {
                //有下一节点，不是叶子
                allTreeLDRtoArray(root.left, list);//L
                list.add(root.val);//D
                allTreeLDRtoArray(root.right, list);//R
            } else
                list.add(root.val);//叶子
        } else {
            list.add(null);//空叶子
        }

    }

    /**
     * 层级保存完全二叉树；小了用LinkedList,大了使用文件
     *
     * @param list
     * @param thisLay 当前层级，初始=1
     */
    public void allTreeLayToArray(List<Integer> list, Integer thisLay) {
        if (queue.isEmpty()) {
            // 队列结束
            return;
        }
        TreeNode root = queue.poll();

        if (root != null) {
            list.add(root.val);
            queue.add(root.left);
            queue.add(root.right);
            //遍历下一层节点
            allTreeLayToArray(list, thisLay + 1);
            allTreeLayToArray(list, thisLay + 1);
        } else if (thisLay <= lay+1) {
            // lay+1代表更多null对象创建，但还在可承受范围的null节点增加。
            list.add(null);
            root = new TreeNode();
            // 入队列
            queue.add(root.left);
            queue.add(root.right);
            // 还在可承受范围的null节点增加。
            allTreeLayToArray(list, thisLay + 1);
            allTreeLayToArray(list, thisLay + 1);
        }
    }


    /**
     * 构造二叉树
     *
     * @param Num
     * @return
     */
    public TreeNode inputTree(int Num) {
        System.out.println("依照先从上到下，再从左到右，构造二叉树");
        System.out.println("构造树编号" + Num + "的根节点值为：");
        // 根节点
        TreeNode treeRootNode = new TreeNode(scanner.nextInt());

        //构造
        System.out.print("根节点");
        inputTreeChild(treeRootNode);

        return treeRootNode;
    }

    /**
     * 判断节点是否结束
     *
     * @param point
     * @return
     */
    private void inputTreeChild(TreeNode point) {
        if (point == null) {
            return;
        }
        System.out.println("值为" + point.val + "的节点有子节点吗？ ");
        if (scanner.nextInt() == 0) {
            System.out.println("本节点结束。");
            return;
        } else {
            System.out.println("有左节点吗？ ");
            if (scanner.nextInt() == 1) {
                System.out.print("左节点值：");
                point.left = new TreeNode(scanner.nextInt());
            }
            System.out.println("有右节点吗？ ");
            if (scanner.nextInt() == 1) {
                System.out.print("右节点值：");
                point.right = new TreeNode(scanner.nextInt());
            }

            if (point.left != null | point.right != null) {
                // 未结束
                if (point.left != null) {
                    System.out.print("母节点值为" + point.val + "的，左，");
                }
                this.inputTreeChild(point.left);
                if (point.right != null) {
                    System.out.print("母节点值为" + point.val + "的，右，");
                }
                this.inputTreeChild(point.right);
                return;
            }
        }
    }

    /**
     * 先序输出
     */
    public void printTreeLDR(TreeNode root) {
        if (root != null) {
            if (root.left != null | root.right != null) {
                //有下一节点，不是叶子
                printTreeLDR(root.left);//L
                System.out.print("--" + root.val);//D
                printTreeLDR(root.right);//R
            } else
                System.out.print("--" + root.val);//输出叶子
        }
    }

    public  void closeScanner() {
        scanner.close();
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees617 treeTool = new MergeTwoBinaryTrees617();
        System.out.println("两二叉树最大的层为几层?");
        treeTool.lay = treeTool.scanner.nextInt();
        // 构造二叉树
        TreeNode root1 = treeTool.inputTree(1);
        TreeNode root2 = treeTool.inputTree(2);

        System.out.println("树1，树2先序遍历：");
        treeTool.printTreeLDR(root1);
        System.out.println();
        treeTool.printTreeLDR(root2);
        System.out.println();
        // 合并二叉树
        treeTool.mergeTrees(root1, root2);

        treeTool.closeScanner();

    }

 //    // 解法2
 // if (t1 == null && t2 == null) return null;
 //
 //    int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
 //    TreeNode newNode = new TreeNode(val);
 //
 //    newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
 //    newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
 //
 //        return newNode;
}