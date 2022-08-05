package org.ohx.codinginterviews.question33;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/8/5
 */
public class SequenceOfBST {
    public boolean verifySequenceOfBST(int[] sequence) {
        if (Objects.isNull(sequence) || sequence.length < 1) {
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > 0) {
            left = verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }

        boolean right = true;
        if (i < length - 1) {
            right = verifySequenceOfBST(Arrays.copyOfRange(sequence, i, length - 1));
        }

        return left && right;
    }
}
