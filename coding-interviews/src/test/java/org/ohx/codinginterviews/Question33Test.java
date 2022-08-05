package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question33.SequenceOfBST;

/**
 * @author mudkip
 * @date 2022/8/5
 */
public class Question33Test {

    @Test
    public void test1() {
        int[] sequence = new int[]{10, 2};

        new SequenceOfBST().verifySequenceOfBST(sequence);
    }
}
