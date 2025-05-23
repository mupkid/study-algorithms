# [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/)

> 给你一个字符串 s，找到 s 中最长的回文子串。
>
> 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

提示：

* 1 <= s.length <= 1000
* s 仅由数字和英文字母（大写和/或小写）组成

标签：`字符串` `动态规划`

## 1 暴力

* 时间复杂度O(n^3)
* 空间复杂度O(1)

```java
class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // s.charAt(i)每次都会检查数组下标越界，因此先转换成字符数组，这一步非必须
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证子串 s[left..rignt] 是否为回文串
     */
    private static boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

## 2 中心扩散

枚举所有可能的回文子串的中心位置，中心位置可能是一个字符，也有可能是两个相邻的字符，记录最长回文子串的相关变量

* 时间复杂度O(n^2) 枚举中心位置的个数是2(n-1)，每一边向两边扩散检测是否是回文
* 空间复杂度O(1)

```java
class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();
        // 最后一个字符不用枚举，因为不可能向右边扩散
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                // 回文串起点坐标需要记录
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param charArray 原始字符串的字符数组
     * @param left      起始左边界（可以取到）
     * @param right     起始右边界（可以取到）
     * @return 回文串的长度
     */
    private static int expandAroundCenter(char[] charArray, int left, int right) {
        // 当 left = right 的时候，回文中心是一个字符，回文串长度是奇数
        // 当 right = left + 1 的时候，回文中心两个字符，回文串长度是偶数
        int len = charArray.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 跳出while循环时，恰好满足 s.charAt(i) != s.charAt(j)
        // 回文串长度是 j-i+1-2 = j-i-1
        return j - i - 1;
    }
}
```

## 3 动态规划

回文串天然具有状态转移特性，因为回文串去掉两头仍然是回文串

定义 P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串 s[i..j] 是否为回文串，写出状态转移方程 P(i,j) = P(i+1,j-1) && (s[i]==s[j]) (j-i >= 2)
边界条件：子串长度为1或2 得 P(i,i) = true, P(i, i+1) = (s[i] == s[i+1])

* 时间复杂度：O(n^2)
* 空间复杂度：O(n^2)
* 动态规划枚举的子串个数：O(n^2)
* 中心扩散枚举的子串个数：O(2n)

```java
class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int begin = 0, subLen = 0;
        for (int k = 0; k < len; k++) {
            // dp[i][j]参考它左下方dp[i-1][j+1]的值
            // 应该先升序填列，后升序填行
            for (int i = 0; i + k < len; i++) {
                int j = i + k;
                if (k == 0) {
                    // k==0时，即i==j，子串长度为1，得到P(i,j)=true
                    dp[i][j] = true;
                } else if (k == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && k + 1 > subLen) {
                    // 如果s[i..j]是回文串，记录子串起点坐标和长度
                    begin = i;
                    subLen = k + 1;
                }
            }
        }
        return s.substring(begin, begin + subLen);
    }
}
```

另一种写法

```java
class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] == charArray[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
```

## 4 Manacher算法

专门用于查找最长回文子串的算法。面试不要求。

* 时间复杂度O(n)

```java
class Solution {
    public static String longestPalindrome(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
}
```

```java
class Solution {
    public String longestPalindrome(String s) {
        // Manacher 模板
        // 将 s 改造为 t，这样就不需要讨论 len(s) 的奇偶性，因为新串 t 的每个回文子串都是奇回文串（都有回文中心）
        // s 和 t 的下标转换关系：
        // (si+1)*2 = ti
        // ti/2-1 = si
        // ti 为偶数，对应奇回文串（从 2 开始）
        // ti 为奇数，对应偶回文串（从 3 开始）
        int n = s.length();
        char[] t = new char[n * 2 + 3];
        Arrays.fill(t, '#');
        t[0] = '^';
        for (int i = 0; i < n; i++) {
            t[i * 2 + 2] = s.charAt(i);
        }
        t[n * 2 + 2] = '$';

        // 定义一个奇回文串的回文半径=(长度+1)/2，即保留回文中心，去掉一侧后的剩余字符串的长度
        // halfLen[i] 表示在 t 上的以 t[i] 为回文中心的最长回文子串的回文半径
        // 即 [i-halfLen[i]+1,i+halfLen[i]-1] 是 t 上的一个回文子串
        int[] halfLen = new int[t.length - 2];
        halfLen[1] = 1;

        // maxI 记录最长回文子串在 halfLen 中的下标
        int maxI = 0;
        // boxR 表示当前右边界下标最大的回文子串的右边界下标+1
        // boxM 为该回文子串的中心位置，二者的关系为 r=mid+halfLen[mid]
        int boxM = 0;
        int boxR = 0;
        for (int i = 2; i < halfLen.length; i++) {
            int hl = 1;
            if (i < boxR) {
                // 记 i 关于 boxM 的对称位置 i'=boxM*2-i
                // 若以 i' 为中心的最长回文子串范围超出了以 boxM 为中心的回文串的范围（即 i+halfLen[i'] >= boxR）
                // 则 halfLen[i] 应先初始化为已知的回文半径 boxR-i，然后再继续暴力匹配
                // 否则 halfLen[i] 与 halfLen[i'] 相等
                hl = Math.min(halfLen[boxM * 2 - i], boxR - i);
            }

            // 暴力扩展
            while (t[i - hl] == t[i + hl]) {
                hl++;
                boxM = i;
                boxR = i + hl;
            }

            halfLen[i] = hl;
            if (hl > halfLen[maxI]) {
                maxI = i;
            }
        }

        int hl = halfLen[maxI];
        // 注意 t 上的最长回文子串的最左边和最右边都是 '#'
        // 所以要对应到 s，最长回文子串的下标是从 (maxI-hl)/2 到 (maxI+hl)/2-2
        return s.substring((maxI - hl) / 2, (maxI + hl) / 2 - 1);
    }
}
```
