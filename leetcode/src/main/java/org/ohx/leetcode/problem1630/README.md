# [1630. 等差子数组](https://leetcode.cn/problems/arithmetic-subarrays)

## 1 直接模拟

```java
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
            res.add(isDifferentialSequence(nums, l[i], r[i]));
        }
        return res;
    }

    private Boolean isDifferentialSequence(int[] nums, int l, int r) {
        if (r - l < 2) {
            return Boolean.TRUE;
        }
        int[] temp = Arrays.copyOfRange(nums, l, r + 1);
        Arrays.sort(temp);
        int difference = temp[1] - temp[0];
        for (int i = 1; i < temp.length - 1; i++) {
            if (temp[i] + difference != temp[i + 1]) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
```

## 2 高效一点的

因为都是 int，所以差也是 int

```java
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; ++i) {
            result.add(check(nums, l[i], r[i]));
        }
        return result;
    }

    private Boolean isDifferentialSequence(int[] nums, int l, int r) {
        if (r - l < 2) {
            return Boolean.TRUE;
        }
        int min = (int) 1e9, max = -(int) 1e9;
        for (int i = l; i <= r; ++i) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return Boolean.TRUE;
        }
        if ((max - min) % (r - l) != 0) {
            // 最大最小值之间不能平分
            return Boolean.FALSE;
        }
        int d = (max - min) / (r - l);
        boolean[] dict = new boolean[r - l + 1];
        for (int i = l; i <= r; ++i) {
            if ((nums[i] - min) % d != 0) {
                // 差不对
                return Boolean.FALSE;
            }
            int j = (nums[i] - min) / d;
            if (dict[j]) {
                // 有重复的数
                return Boolean.FALSE;
            }
            dict[j] = true;
        }
        return Boolean.TRUE;
    }
}
```
