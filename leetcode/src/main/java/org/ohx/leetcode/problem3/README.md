# [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters)

## 滑动窗口

枚举左端点
```java
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int n = s.length();
        // 右下标，初始值为-1，相当于在字符串的左边界的左侧，还没有移动
        int right = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            // i相当于窗口左下标
            if (i != 0) {
                // 把窗口左边从散列表中删除
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(++right));
            }
            // 第i到rk个字符是一个极长的无重复字符子串
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}
```

枚举右端点
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.computeIfAbsent(c, k -> 0) + 1);
            while (map.get(c) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
```