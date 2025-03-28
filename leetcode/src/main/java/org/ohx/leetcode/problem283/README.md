# [283. 移动零](https://leetcode.cn/problems/move-zeroes)

## 双指针
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int i0 = 0;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i0];
                nums[i0] = nums[i];
                nums[i] = temp;
                i0++;
            }
        }
    }
}
```
只需要遍历一次，但是最坏时每个元素都需要做一次交换。

把非零的数字都放到前面，剩下的都填充0。
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int p = removeElement(nums, 0);
        // 将 nums[p..] 的元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
```
这样需要最坏情况下需要遍历两次。