# [238. 除自身以外数组的乘积](https://leetcode.cn/problems/product-of-array-except-self/)

## 思路

不能使用除法。 时间复杂度 O(n)，空间复杂度 O(1)。

如果知道 i 左边所有数的乘积，以及 i 右边所有数的乘积，那么就能算出 answer[i]。

## 空间复杂度 O(n) 
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        pre[0] = 1;
        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        int[] suf = new int[length];
        suf[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = pre[i] * suf[i];
        }
        return ans;
    }
}
```