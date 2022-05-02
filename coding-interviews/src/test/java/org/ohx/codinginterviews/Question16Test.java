package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question16.Power;

/**
 * @author mudkip
 * @date 2022/5/2
 */
public class Question16Test {
    @Test
    public void Test1() {
        System.out.println(Power.recursionPower(2, 10));
        System.out.println(Power.quickPower(3, 9));
    }
}
