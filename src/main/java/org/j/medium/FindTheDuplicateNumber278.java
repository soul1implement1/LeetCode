package org.j.medium;

import java.util.Arrays;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 找重复的数；给定一个nums包含  n + 1整数的整数数组，
 * 其中每个整数都在包含范围内[1, n]。
 * 只有一个重复的号码中nums，返回这个重复的号码。
 * @date 2020-09-15 14:17
 **/
public class FindTheDuplicateNumber278 {

    public static int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for (int i = 0; i <nums.length ; i++) {
        //     if (nums[i]==nums[i+1]){
        //         return nums[i];
        //     }
        // }
        // return 0;
        int ans=0,len=nums.length;
        boolean[] bool = new boolean[len];

        for(int i=0;i<len;i++){
            if(bool[nums[i]-1]==true){
                return nums[i];
            }
            else{
                bool[nums[i]-1]=true;
            }
        }

        return 0;


    }



    public static void main(String[] args) {
        int k = 5;
        int[] a = new int[k];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = i + 1;
        }
        a[k - 1] = 3;
        long st = System.currentTimeMillis();
        System.out.println(findDuplicate(a));
        System.out.println(System.currentTimeMillis() - st);

    }
}
