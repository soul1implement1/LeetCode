package org.j.medium;

import java.util.*;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 347给定一个非空的整数数组，返回k个最频繁的元素。
 * @date 2020-08-31 9:58
 **/
public class TopKFrequentElements347 {
    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer temp;
            if ((temp = map.get(nums[i])) == null) {
                map.put(nums[i], 1);
            } else {
                temp++;
                map.put(nums[i], temp);
            }
        }
        if (map.size() == k) {
            int[] result = new int[k];
            int j = 0;
            for (Integer i : map.keySet()) {
                result[j] =i;
                j++;
            }

            return result;
        }
        return topKFrequentHelper(map, k);
    }

    // n*logK
    public static int[] topKFrequentHelper(HashMap<Integer, Integer> map, int k) {

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;

    }

    public static void main(String[] args) {
        // int[] r = topKFrequent(new int[]{-1,-1,-1,1, 8, 8, 5, 5, 9, 3, 3, 1, 2, 1, 2, 3}, 3);
        int[] r = topKFrequent(new int[]{-1,-1,-1}, 1);
        for (int i : r) {
            System.out.println(i);
        }
    }
}
