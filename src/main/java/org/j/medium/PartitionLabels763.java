package org.j.medium;

import org.j.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description S给出一串小写英文字母。我们希望将此字符串划分为尽可能多的部分，以便每个字母最多显示一个部分
 * ，并返回代表这些部分大小的整数列表。
 * @date 2020-09-09 9:32
 **/
public class PartitionLabels763 {

    public static List<Integer> partitionLabels(String S) {
        // List<Integer> result = new ArrayList<>();
        // char[] arr = S.toCharArray();
        // // 被锁住的字符的起止下标
        // int lockEndIndex;
        // int lockStartIndex =1;
        // // 上一划分的终止字符下标,初值取0
        // int lastIndex = -1;
        // for (int i = 0; i < arr.length; i++) {
        //     // 找一个划分的终止字符
        //     lockEndIndex = S.lastIndexOf(arr[i]);
        //     if (i == lockEndIndex && (i == 0 )) {
        //         // 在此划分的始终没有人超过最后一个被锁住的字母，完成了一个划分的的查找
        //         result.add(lockEndIndex - lastIndex);
        //         lockStartIndex = lockEndIndex + 1;
        //         lastIndex = lockEndIndex;
        //         continue;
        //     }
        //     for (int j = lockStartIndex; j <= lockEndIndex; j++) {
        //         // 更新终止字符
        //         int lockEndIndexTemp = S.lastIndexOf(arr[j]);
        //
        //         if (lockEndIndexTemp < lockEndIndex) {
        //             // 在此划分的始终没有人超过最后一个被锁住的字母，完成了一个划分的的查找
        //             result.add(lockEndIndex - lastIndex);
        //
        //             lockStartIndex = lockEndIndex + 1;
        //             lastIndex = lockEndIndex;
        //             // 加快迭代
        //             i = j + 1;
        //             break;
        //         } else if (lockEndIndexTemp > lockEndIndex) {
        //             lockEndIndex = lockEndIndexTemp;
        //         } else if (lockEndIndexTemp == lockEndIndex && (j == 0 || j == S.length()-1)) {
        //             // 在此划分的始终没有人超过最后一个被锁住的字母，完成了一个划分的的查找
        //             result.add(lockEndIndex - lastIndex);
        //             lockStartIndex = lockEndIndex + 1;
        //             lastIndex = lockEndIndex;
        //             // 加快迭代
        //             i = j + 1;
        //             break;
        //         }
        //     }
        // }
        //
        // return result;


        List<Integer> li = new ArrayList<>();
        int[] ar = new int[26];
        for(int i=0; i<S.length(); i++){
            ar[S.charAt(i)-'a']=i;
        }
        int lastIndex = 0;
        int prev=0;
        while(lastIndex < S.length()){
            for(int i=lastIndex; i<=lastIndex ; i++){
                lastIndex = Math.max(ar[S.charAt(i)-'a'],lastIndex);
            }
            li.add(++lastIndex-prev);
            prev = lastIndex;
        }
        return li;
    }

    public static void main(String[] args) {
        //  // a,e,j
        // long st = System.currentTimeMillis();
        Tool.printList(partitionLabels("ababcbacadefegdehijhklij"));
        // System.out.println(System.currentTimeMillis() - st);
        Tool.printList(partitionLabels("caedbdedda"));

        Tool.printList(partitionLabels("eccbbbbdec"));
    }
}
