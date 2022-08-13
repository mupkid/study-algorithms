package org.ohx.codinginterviews.question38;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/8/13
 */
public class StringPermutation {
    ArrayList<String> strings = new ArrayList<>();

    public ArrayList<String> permutation(String str) {
        if (Objects.isNull(str) || str.length() < 1) {
            return strings;
        }

        permutation(str.toCharArray(), 0);
        return strings;
    }

    public void permutation(char[] str, int index) {
        if (index >= str.length - 1) {
            strings.add(new String(str));
            return;
        }
        for (int i = index; i < str.length; i++) {
            char temp = str[index];
            str[index] = str[i];
            str[i] = temp;

            permutation(str, index + 1);

            temp = str[index];
            str[index] = str[i];
            str[i] = temp;
        }
    }
}
