package org.ohx.leetcode.question1700;

/**
 * @author mudkip
 * @date 2022/10/19
 */
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }

        int length = sandwiches.length;
        for (int i = 0; i < length; i++) {
            if (--count[sandwiches[i]] == -1) {
                return students.length - i;
            }
        }
        return 0;
    }
}
