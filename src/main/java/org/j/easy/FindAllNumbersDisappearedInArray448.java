package org.j.easy;

import org.j.Tool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 给定整数的数组，其中1≤A [1]≤ Ñ（Ñ =数组的大小），一些元件出现两次以及其他出现一次。
 * 查找[1，n ]包含的所有未出现在此数组中的元素。
 * @date 2020-09-14 9:40
 **/
public class FindAllNumbersDisappearedInArray448 {

    public static void main(String[] args) {
        Tool.printList(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1, 1, 8}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // for (int i = 1; i <= nums.length; i++) {
        //     result.add(i);
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     result.remove(Integer.valueOf(nums[i]));
        // }
        //
        for (int i = 0; i < nums.length; i++) {
            if (nums[nums[i]-1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                result.add(j+1);
            }
        }

        return result;
    }
}
