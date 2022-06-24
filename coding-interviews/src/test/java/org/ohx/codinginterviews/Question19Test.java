package org.ohx.codinginterviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question19.RegularExpressions;

/**
 * @author mudkip
 * @date 2022/6/24
 */
public class Question19Test {
    @Test
    public void test1() {
        Assertions.assertTrue(RegularExpressions.match("aaa", "a.a"));
        Assertions.assertTrue(RegularExpressions.match("aaa", "ab*ac*a"));
        Assertions.assertFalse(RegularExpressions.match("aaa", "aa.a"));
        Assertions.assertFalse(RegularExpressions.match("aaa", "ab*a"));
        Assertions.assertFalse(RegularExpressions.match("aaa", "a.aa"));
    }
}
