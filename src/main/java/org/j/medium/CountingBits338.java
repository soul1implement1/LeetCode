package org.j.medium;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 338给定一个非负整数 num。对于范围0≤ i ≤ num 的每个数 i，计算其二进制表示中的1的个数并将其作为数组返回。
 * @date 2020-08-21 12:32
 **/
public class CountingBits338 {
    /**
     * 输出对应数字的二进制1的数量
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] dp = new int[num+1];
        //Fact: If a number(n) is odd then no. of set bits is 1+n/2; else n/2.

        for(int i=0; i <=num ; i++){

            if(i%2 ==0){
                dp[i] = dp[i/2];
            }
            else{
                dp[i] = 1 + dp[i/2];
            }

        }
        return dp;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        if (num < 0) {
            System.out.println("输入错误");
            return;
        }
        int[] a=CountingBits338.countBits(num);
        for (int q:a
             ) {
            System.out.print(q+",");

        }
    }
}
