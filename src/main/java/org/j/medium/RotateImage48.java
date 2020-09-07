package org.j.medium;

import org.j.Tool;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 您将得到一个代表图像的n x n 2D matrix，将图像旋转90度（顺时针）。
 * 您必须就地旋转图像，这意味着您必须直接修改输入2D矩阵。不要分配另一个2D矩阵并进行旋转。
 * @date 2020-09-07 9:28
 **/
public class RotateImage48 {

    public static int[][] rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        }
        return matrix;
    }

    public static void main(String[] args) {
        // Tool.print(rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        long st=System.currentTimeMillis();
        Tool.print(rotate(new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7},{15,14,12,16}}));
        // Tool.print(rotate(new int[][]{{15,14,12,16,8},{15,14,12,16,8},{15,14,12,16,8},{15,14,12,16,8},{15,14,12,16,8}}));
        System.out.println(System.currentTimeMillis()-st);
    }
}
