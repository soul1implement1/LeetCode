package org.j;

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
}
