package org.ohx.codinginterviews.question39;

/**
 * @author mudkip
 * @date 2022/8/14
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int more = array[0];
        int score = 1;
        for (int i = 1; i < array.length; i++) {
            if (score == 0) {
                more = array[i];
                score++;
                continue;
            }
            if (array[i] == more) {
                score++;
            } else {
                score--;
            }
        }
        return more;
    }
}
