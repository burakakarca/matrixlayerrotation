package com.rotation;

import java.util.List;

public class Result {
    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            rotate(matrix, layer, r, m, n);
        }

        for (List<Integer> row : matrix) {
            System.out.println(row.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static void rotate(List<List<Integer>> matrix, int layer, int r, int m, int n) {
        int top = layer;
        int left = layer;
        int bottom = m - layer - 1;
        int right = n - layer - 1;

        int perimeter = 2 * (bottom - top + right - left);
        r %= perimeter;
        if (r == 0) return;

        for (int rotation = 0; rotation < r; rotation++) {
            int temp = matrix.get(top).get(left);

            for (int j = left; j < right; j++) {
                matrix.get(top).set(j, matrix.get(top).get(j + 1));
            }

            for (int i = top; i < bottom; i++) {
                matrix.get(i).set(right, matrix.get(i + 1).get(right));
            }

            for (int j = right; j > left; j--) {
                matrix.get(bottom).set(j, matrix.get(bottom).get(j - 1));
            }

            for (int i = bottom; i > top; i--) {
                matrix.get(i).set(left, matrix.get(i - 1).get(left));
            }

            matrix.get(top + 1).set(left, temp);
        }
    }
}
