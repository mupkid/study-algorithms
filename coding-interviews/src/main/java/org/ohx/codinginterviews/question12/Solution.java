package org.ohx.codinginterviews.question12;

/**
 * 面试题12：矩阵中的路径
 * <p>
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 * 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 * 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 * 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 * 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * A B T G
 * <p>
 * C F C S
 * <p>
 * J D E H
 * <p>
 * 牛客网版本
 *
 * @author mudkip
 * @date 2022/4/20 22:48
 */
public class Solution {
    public boolean hasPath(char[][] matrix, String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, String word, int i, int j, int index) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || matrix[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = matrix[i][j];
        matrix[i][j] = '.';
        boolean res = dfs(matrix, word, i + 1, j, index + 1)
                || dfs(matrix, word, i - 1, j, index + 1)
                || dfs(matrix, word, i, j + 1, index + 1)
                || dfs(matrix, word, i, j - 1, index + 1);
        matrix[i][j] = temp;
        return res;
    }
}
