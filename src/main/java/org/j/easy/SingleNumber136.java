package org.j.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 136给定一个非空  的整数数组，每个元素出现两次，除了一个。找到那一个。
 * @date 2020-08-28 16:18
 **/
public class SingleNumber136 {
    public static int singleNumber(int[] nums) {
        // Arrays.sort(nums);
        // int last = nums[0];
        //
        // for (int i = 1; i < nums.length; i+=2) {
        //     if (last == nums[i]) {
        //         last = nums[i + 1];
        //         continue;
        //     } else {
        //         break;
        //     }
        // }
        // return last;


        // int result = nums[0];
        //
        // for (int i = 1; i < nums.length / 2 + 1; i++) {
        //     result += nums[i];
        // }
        // System.out.println(result);
        // for (int i = nums.length / 2+1; i < nums.length; i++) {
        //     result -= nums[i];
        // }
        // return result;


        int current = nums[0];
        for(int i = 1; i < nums.length; i++){
            current ^= nums[i];
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{8,8,5,5,9, 3, 1, 2, 1, 2, 3}));
    }
}
