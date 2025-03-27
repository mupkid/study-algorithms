# [49. 字母异位词分组](https://leetcode.cn/problems/group-anagrams/description)

同一组字母异位词中的字符串具备一些相同点，比如：

* 把字符串中的字符排序后顺序是一样的
* 字符串中相同的字母出现的次数是相同的

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
```