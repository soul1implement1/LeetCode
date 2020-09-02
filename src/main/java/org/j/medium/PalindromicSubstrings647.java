package org.j.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 647给定一个字符串，您的任务是计算该字符串中有多少个回文子字符串。
 * 即使起始索引或终止索引不同的子字符串由相同的字符组成，也将被计为不同的子字符串。
 * @date 2020-08-31 13:02
 **/
public class PalindromicSubstrings647 {
    public static int countSubstrings(String s) {
        char arr[] = s.toCharArray();
        int count=0;
        for(int i=0;i<arr.length;i++) {
            count+=getPalindrome(arr,i,i+1);
            count+=getPalindrome(arr,i,i);
        }
        return count;
    }

    public static int getPalindrome(char arr[],int l,int r) {
        if(r==arr.length)
            return 0;
        int count=0;
        while(l>=0&&r<arr.length&&arr[l]==arr[r]) {
            count++;l--;r++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaaa"));
    }



}
