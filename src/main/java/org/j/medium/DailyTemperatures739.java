package org.j.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 739每日温度
 * @date 2020-08-25 14:00
 **/
public class DailyTemperatures739 {
    // T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

    /**
     *不用堆栈
     *
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        // Current date (subscript)
        int point = 0;
        // Number of days between reaching higher temperature
        for (int i = 1; i < T.length; i++) {
            if (T[point] < T[i]) {
                // reaching higher temperature1
                T[point] =1;// i-point
            } else {
                int j = i;
                j++;
                while (j < T.length) {
                    if (T[point] < T[j]) {
                        // reaching higher temperature2
                        T[point] = j-point;
                        break;
                    }
                    j++;
                }
                if (j == T.length) {
                    // put 0 instead
                    T[point] = 0;
                }
            }
            point = i;
        }
        // last data must zero
        T[T.length - 1] = 0;
        return T;
    }


    public static void main(String[] args) {
        int[] result = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73, 72, 71, 68});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + ",");
        }
    }
}
