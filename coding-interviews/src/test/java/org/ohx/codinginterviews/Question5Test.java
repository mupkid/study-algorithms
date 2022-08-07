package org.ohx.codinginterviews;

import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question5.Solution;

/**
 * @author mudkip
 * @date 2022/8/7
 */
public class Question5Test {
    @Test
    public void test1() {
        System.out.println(new Solution().replaceSpace("We are happy."));
    }

    @Test
    public void replaceTest() {
        System.out.println("We are happy".replace(" ", "%20"));
        System.out.println("We are happy".replaceAll(" ", "%20"));
    }
}
