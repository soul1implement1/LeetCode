package org.j.medium;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 238给定阵列nums的Ñ整数其中Ñ > 1时，返回一个数组output，
 * 使得output[i]等于所有元素的乘积nums除nums[i]。
 * @date 2020-09-01 16:54
 **/
public class ProductOfArrayExceptSelf238 {

    public static int[] productExceptSelf(int[] nums) {
        // 利用以前的结果
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 0; i < n-1; i++) {
            left[i+1] = left[i] * nums[i];
        }
        for (int i = n - 1; i >0; i--) {
            right[i-1] = right[i] * nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
        // for (int i = 0; i <result.length ; i++) {
        //     int total=1;
        //     for (int j = i+1; j <n ; j++) {
        //         total*=nums[j];
        //     }
        //     for (int j = i-1; j>=0; j--) {
        //         total*=nums[j];
        //     }
        //     result[i]=total;
        // }
        // return result;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
        // System.out.println((3<<2)+3);
        // System.out.println(3^2);
        // System.out.println(3&2);
    }
}
