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

    private void recursion(ArrayList<String> res, char[] str, StringBuffer temp, boolean[] vis) {
        // 临时字符串满了加入输出
        if (temp.length() == str.length) {
            res.add(new String(temp));
            return;
        }
        // 遍历所有元素选取一个加入
        for (int i = 0; i < str.length; i++) {
            if (vis[i] || (i > 0 && str[i - 1] == str[i] && !vis[i - 1])) {
                // 剪枝条件：
                // 1、元素已经访问过
                // 2、元素和前一个相同，而且前一个元素已经访问过了
                // 因为已经按照字典序对元素进行排序了，而且也保证了是从左到右开始选择元素进行添加的
                // 不需担心走到下一层后用过的元素又被用一次
                continue;
            }

            // 使用元素，加入临时字符串，标记为使用过
            vis[i] = true;
            temp.append(str[i]);

            // 回溯
            recursion(res, str, temp, vis);

            // 该子树下的递归结束了，移除
            temp.deleteCharAt(temp.length() - 1);
            vis[i] = false;
        }
    }
}
