package org.j.medium;

import java.util.Arrays;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 在未排序的数组中找到第k个最大元素。请注意，它是排序顺序中第k个最大的元素，而不是第k个不同的元素。
 * @date 2020-09-15 16:00
 **/
public class KthLargestElementInArray215 {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];

    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
