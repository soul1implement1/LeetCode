package org.j;

import java.util.List;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 输出调试
 * @date 2020-09-07 10:13
 **/
public class Tool {
    public static void print(int[][] binary) {
        System.out.println("-------test");
        for (int[] a : binary) {
            for (int b : a) {
                System.out.print(b + ",");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    public static void printList(List<Integer> list ) {
        for (Object o:list) {
            System.out.print(o+",");
        }
        System.out.println();
    }

    /**
     * @paramType  List<List<Integer>>
     * @param lists
     */
    public static void printListList(List<List<Integer>> lists){
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }
}
