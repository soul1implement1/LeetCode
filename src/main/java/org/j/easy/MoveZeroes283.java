package org.j.easy;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 283给定一个数组nums，编写一个函数将所有0'移到其末尾，同时保持非零元素的相对顺序
 * @date 2020-09-04 15:12
 **/
public class MoveZeroes283 {

    public static void moveZeroes(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) nums[i] = 0;
        for (int i = 0; i < nums.length; i++) System.out.print(nums[i] + ",");
        System.out.println();

    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 8, 5, 0, 0, 7, 11, 0, 99});
    }
}
