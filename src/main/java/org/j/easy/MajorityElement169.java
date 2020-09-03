package org.j.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 给定大小为n的数组，找到多数元素。大多数元素是出现的元素不止 ⌊ n/2 ⌋倍。
 * 您可以假设数组为非空，并且多数元素始终存在于数组中。
 * @date 2020-09-03 9:18
 **/
public class MajorityElement169 {
    public static int majorityElement(int[] nums) {
        //   int len = nums.length / 2;
        //   Map<Integer, Integer> map = new HashMap<>();
        //   for (int i = 0; i < nums.length; i++) {
        //       // if (map.containsKey(nums[i])) {
        //       //     map.put(nums[i],map.get(nums[i])+1);
        //       // } else {
        //       //     map.put(nums[i], 1);
        //       // }
        //       // map.containsKey(nums[i]) o(lgn)
        //       Object temp=map.get(nums[i]);
        //
        //       if (temp!=null) {
        //           map.put(nums[i],((int)temp)+1);
        //       } else {
        //           map.put(nums[i], 1);
        //       }
        //   }
        // for (Integer i: map.keySet()){
        //     if (map.get(i)>len){
        //         len=i;
        //         break;
        //     }
        // }
        //   return len;
        int n = nums.length, m = nums[0], c = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == m) {
                c++;
            } else if (c > 0) {
                c--;
            } else {
                m = nums[i]; c = 1;
            }
        }

        return m;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2,3}));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{3, 2, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 3, 3, 2}));
    }
}
