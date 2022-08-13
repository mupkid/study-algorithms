package org.ohx.codinginterviews.question38;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 牛客网版本：JZ38 字符串的排列
 * <p>
 * 描述：输入一个长度为 n 字符串，打印出该字符串中字符的所有组合，你可以以任意顺序返回这个字符串数组。
 * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB。
 * <p>
 * 数据范围：n < 10，字符只包括大小写字母。
 * 要求：空间复杂度 O(n!)，时间复杂度 O(n!)
 *
 * @author mudkip
 * @date 2022/8/13
 */
public class Solution {
    public void recursion(ArrayList<String> res, char[] str, StringBuffer temp, boolean[] vis) {
        // 临时字符串满了加入输出
        if (temp.length() == str.length) {
            res.add(new String(temp));
            return;
        }
        // 遍历所有元素选取一个加入
        for (int i = 0; i < str.length; i++) {
            // 如果该元素已经被加入了则不需要再加入了
            if (vis[i]) {
                continue;
            }
            if (i > 0 && str[i - 1] == str[i] && !vis[i - 1]) {
                // 当前的元素str[i]与同一层的前一个元素str[i-1]相同且str[i-1]已经用过了
                continue;
            }
            // 标记为使用过
            vis[i] = true;
            // 加入临时字符串
            temp.append(str[i]);
            recursion(res, str, temp, vis);
            // 回溯
            vis[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return res;
        }
        // 转字符数组
        char[] charStr = str.toCharArray();
        // 按字典序排序
        Arrays.sort(charStr);
        boolean[] vis = new boolean[str.length()];
        //标记每个位置的字符是否被使用过
        Arrays.fill(vis, false);
        StringBuffer temp = new StringBuffer();
        //递归获取
        recursion(res, charStr, temp, vis);
        return res;
    }
}
