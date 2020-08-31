package org.j.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 406假设您有排队的人的随机列表。 每个人都用一对整数（h，k）描述，其中h是人的身高，k是在此人前面的身高大于或等于h的人数。 编写算法以重建队列。
 * @date 2020-08-21 16:03
 **/
public class QueueReconstructionByHeight406 {
    public static int[][] reconstructQueue(int[][] people) {
        // 找最高的人,并且将k排序
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] -p1[1] : p2[0] - p1[0]);

        for (int i = 1; i < people.length; i++) {
            int index = people[i][1];
            int[] intsHigh = people[i];
            for (int j = i - 1; j >= index; j--) {
                people[j + 1] = people[j];
            }
            people[index] = intsHigh;

        }
        return people;
        // List<int[]> result = new ArrayList<>(people.length);
        //
        // for (int[] p : people){
        //     result.add(p[1],p);
        // }
        //
        // return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] people = { {7, 1},{7, 0},{7,2}, {4, 4}, {6, 1}, {5, 2}, {5, 0}};
        int[][] people1 = reconstructQueue(people);

        for (int[] a : people1) {
            for (int b : a) {
                System.out.print(b + ",");
            }
            System.out.println();
        }
    }
}
