package org.j.medium;

import org.j.Tool;

import java.util.*;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 给定一组候选数（candidates）（无重复项）和目标数（target），
 * 找到candidates 候选数总和为的所有唯一组合target。
 * 的相同重复数目可以选自candidates 无限次数。
 * @date 2020-09-10 10:06
 **/

public class CombinationSum39 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 5}, 8);
        Tool.printListList(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        //比target小的数组。
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                candidates[index] = candidates[i];
                index++;
            }
        }
        int[] newCandidates = Arrays.copyOfRange(candidates, 0, index);
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(0,newCandidates, target, result, new  LinkedList<>());

        return result;
    }

    public static void combinationSumHelper(int index, int[] candidates, int target, List<List<Integer>> result, LinkedList<Integer> list) {

        if (target==0) {
            result.add(new ArrayList<>(list));
            return ;
        }else if(target<0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSumHelper(i, candidates,target - candidates[i] , result, list);
            list.removeLast();
        }

    }

}
