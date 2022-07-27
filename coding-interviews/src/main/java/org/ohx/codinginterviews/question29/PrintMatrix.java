package org.ohx.codinginterviews.question29;

import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/7/27
 */
public class PrintMatrix {
    public void printMatrix(int[][] matrix) {
        if (Objects.isNull(matrix)) {
            return;
        }
        int row = matrix.length;
        if (row <= 0) {
            return;
        }
        int column = matrix[0].length;
        if (column <= 0) {
            return;
        }

        int start = 0;
        while (column > start * 2 && row > start * 2) {
            printMatrixInCircle(matrix, column, row, start);
            ++start;
        }
    }

    public void printMatrixInCircle(int[][] matrix, int column, int row, int start) {
        int endX = column - 1 - start;
        int endY = row - 1 - start;

        for (int i = start; i <= endX; i++) {
            System.out.println(matrix[start][i]);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.println(matrix[i][endX]);
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                System.out.println(matrix[endY][i]);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                System.out.println(matrix[i][start]);
            }
        }
    }
}
