package org.j.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 给定一组不同的整数nums，返回所有可能的子集（幂集）。
 * @date 2020-08-28 14:02
 **/
public class Subsets78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n:nums) {
            List<List<Integer>> resultT = new ArrayList<>();
            for (List<Integer > list:result) {
                resultT.add(new ArrayList<Integer>(list){{add(n);}});
            }
            result.addAll(resultT);
        }
        return result;
    }
    //
    // public static int subsetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
    //     if (start >= nums.length - 1) {
    //         return 0;
    //     }else {
    //         list.add(nums[start]);
    //         result.add(list);
    //         subsetsHelper(result, new ArrayList<>(list), nums, start + 1);
    //     }
    //
    //
    //     return 1;
    // }

    // public static int subsetsHelper(List<Integer> list, int[] nums, int start, int end) {
    //
    //     if (list.size() == nums.length - 1) {
    //         return 0;
    //     }
    //     for (int i = start; i < end; i++) {
    //         list.add(nums[i]);
    //     }
    //     return 1;
    // }
    // public static List<Integer> subsetsHelper(List<Integer> list, int[] nums, int start, int end) {
    //
    //     if (list.size() == nums.length - 1) {
    //         return null;
    //     }
    //     for (int i = start; i < end; i++) {
    //         list.add(nums[i]);
    //     }
    //     return new ArrayList<>(list);
    // }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets78.subsets(new int[]{1, 2, 3, 4});
        for (List<Integer> list : result
        ) {
            for (Integer a : list
            ) {
                System.out.print(a + ",");
            }
            System.out.println("");
        }
    }
}
