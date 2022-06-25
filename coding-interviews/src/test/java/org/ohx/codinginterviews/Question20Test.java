package org.ohx.codinginterviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ohx.codinginterviews.question20.NumericStrings;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Question20Test {
    @Test
    public void Test1() {
        Assertions.assertTrue(NumericStrings.isNumeric("100"));
        Assertions.assertTrue(NumericStrings.isNumeric("123.45e+6"));
        Assertions.assertTrue(NumericStrings.isNumeric("+500"));
        Assertions.assertTrue(NumericStrings.isNumeric("5e2"));
        Assertions.assertTrue(NumericStrings.isNumeric("3.1416"));
        Assertions.assertTrue(NumericStrings.isNumeric("600"));
        Assertions.assertTrue(NumericStrings.isNumeric("-.123"));
        Assertions.assertTrue(NumericStrings.isNumeric("-1E-16"));
        Assertions.assertTrue(NumericStrings.isNumeric("1.79769313486232E+308"));

        Assertions.assertFalse(NumericStrings.isNumeric("12e"));
        Assertions.assertFalse(NumericStrings.isNumeric("1a3.14"));
        Assertions.assertFalse(NumericStrings.isNumeric("1+23"));
        Assertions.assertFalse(NumericStrings.isNumeric("1.2.3"));
        Assertions.assertFalse(NumericStrings.isNumeric("+-5"));
        Assertions.assertFalse(NumericStrings.isNumeric("."));
        Assertions.assertFalse(NumericStrings.isNumeric(".e1"));
        Assertions.assertFalse(NumericStrings.isNumeric("e1"));
        Assertions.assertFalse(NumericStrings.isNumeric("+."));
        Assertions.assertFalse(NumericStrings.isNumeric(""));
        Assertions.assertFalse(NumericStrings.isNumeric(null));
    }
}
