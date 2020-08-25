package org.j.medium;

import java.util.*;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 46给定一组不同的整数，返回所有可能的排列
 * @date 2020-08-24 16:30
 **/
public class Permutations46 {
//     public static List<List<Integer>> permutes(int[] nums, int point) {
//         List<List<Integer>> result = null;
//         List<List<Integer>> result1 = null;
//         if (nums.length > 2) {
//             // System.out.println(point + "\\");
//             if (point < nums.length - 2) {
//                 result = permutes(Arrays.copyOfRange(nums, 0, point), 1);
//                 result1 = permutes(Arrays.copyOfRange(nums, point + 2, nums.length),1);
//             }
//
//             List<List<Integer>> result2 = new ArrayList<>();
//
//             for (List<Integer> list : result) {
//                 for (List<Integer> list1 : result1) {
//                     //小到大
//                     List<Integer> listTemp = new ArrayList<>();
//                     listTemp.addAll(list);
//                     listTemp.addAll(list1);
//                     result2.add(listTemp);
//
//                     //大到小
//                     listTemp = new ArrayList<>();
//                     listTemp.addAll(list1);
//                     listTemp.addAll(list);
//                     result2.add(listTemp);
//                 }
//
//             }
//
//             return result2;
//         } else if (nums.length == 2) {
//             result = new ArrayList<>();
//             List<Integer> list = new ArrayList<>();
//             list.add(nums[0]);
//             list.add(nums[1]);
//             List<Integer> list1 = new ArrayList<>();
//             list1.add(nums[1]);
//             list1.add(nums[0]);
//             result.add(list);
//             result.add(list1);
//         } else if (nums.length == 1) {
//             result = new ArrayList<>();
//             List<Integer> list = new ArrayList<>();
//             list.add(nums[0]);
//             result.add(list);
//         }
//         return result;
//
//     }
//
//     public static List<List<Integer>> permute(int[] nums) {
//         for (int i = 1; i < nums.length; i++) {
//
//             for (List<Integer> list : permutes(nums, i)
//             ) {
//                 System.out.print("[");
//                 for (Integer integer : list) {
//                     System.out.print(integer + ",");
//                 }
//                 System.out.print("]");
//                 System.out.println();
//             }
//
//             System.out.println("/////////////////");
//             System.out.println("/////////////////");
//             System.out.println("/////////////////");
//             System.out.println("/////////////////");
//
//
//         }
// return null;
//     }

    public static void main(String[] args) {
        long st=System.currentTimeMillis();
        List<List<Integer>> result = permute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,14});
        long ed=System.currentTimeMillis();
        System.out.println(ed-st);
        // List<List<Integer>> result = permute(new int[]{1, 2, 3, 4});



        for (List<Integer> list : result
        ) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }


    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        result.add(first);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> resultTemp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> list : result) {
                    List<Integer> list_new = new ArrayList<>(list);
                    // List<Integer> list_new = new ArrayList<>();
                    // list_new.addAll(list);
                    list_new.add(j, nums[i]);
                    resultTemp.add(list_new);
                }
            }
            result = resultTemp;
        }
        return result;



    }

}
