# [394. 字符串解码](https://leetcode-cn.com/problems/decode-string/)

## 辅助栈

```java
class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int num = 0;
        Deque<Integer> stackNum = new ArrayDeque<>();
        Deque<String> stackPre = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                // 括号前的数字入栈
                stackNum.push(num);
                // 括号前的字符串入栈
                stackPre.push(ans.toString());
                num = 0;
                ans = new StringBuilder();
            } else if (c == ']') {
                Integer multi = stackNum.pop();
                String pre = stackPre.pop();
                ans = new StringBuilder(pre + String.valueOf(ans).repeat(Math.max(0, multi)));
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
```

## 递归

```java
class Solution {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']')
                return new String[]{String.valueOf(i), res.toString()};
            else
                res.append(s.charAt(i));
            i++;
        }
        return new String[]{res.toString()};
    }
}
```