package org.ohx.nowcoder.huawei.decodestring;

/**
 * @author mudkip
 * @date 2022/8/31
 */
public class DecodeString {
    int i;

    public String encoded(String s) {
        StringBuilder output = new StringBuilder();

        char[] chars = s.toCharArray();
        i = 0;
        while (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                output.append(encode1(chars));
            } else {
                output.append(chars[i]);
                i++;
            }
        }

        return output.toString();
    }

    private String encode1(char[] c) {
        StringBuilder sb = new StringBuilder();
        while (c[i] >= '0' && c[i] <= '9') {
            sb.append(c[i]);
            i++;
        }
        int num = Integer.parseInt(sb.toString());
        // 跳过[字符
        i++;
        sb = new StringBuilder();
        while (c[i] != ']') {
            if (c[i] >= '0' && c[i] <= '9') {
                sb.append(encode1(c));
            } else {
                sb.append(c[i]);
                i++;
            }
        }
        // 跳过]字符
        i++;
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < num; j++) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeString main = new DecodeString();
        System.out.println(main.encoded("abc3[cd3[cd]]xyz"));
    }
}
