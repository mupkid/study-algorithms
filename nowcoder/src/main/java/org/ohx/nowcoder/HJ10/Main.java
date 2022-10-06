package org.ohx.nowcoder.HJ10;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @author mudkip
 * @date 2022/10/6
 */
public class Main {
    public static void main(String[] args) {
        // 凡是涉及到去重统计都可以用位图实现。因为每一个不同的数据只需要用二进制的一位存储即可，大大减小了统计所使用的存储空间
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        // 总共有128个字符。字需要用128位
        BitSet bitSet = new BitSet(128);
        for (char c : line.toCharArray()) {
            // 判断字符c是否已出现
            if (!bitSet.get(c)) {
                // 未出现就设置为已出现
                bitSet.set(c);
            }
        }
        //统计有多少字符已出现过
        System.out.println(bitSet.cardinality());
    }
}
