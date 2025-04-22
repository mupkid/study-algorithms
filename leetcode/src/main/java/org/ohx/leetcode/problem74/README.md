# [74. 搜索二维矩阵](https://leetcode.cn/problems/search-a-2d-matrix/description/)

## 二分查找

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = -1;
        int right = m * n;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            }
            if (x < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return false;
    }
}
```

时间复杂度 O(log(m * n))

## 排除法

同 [240. 搜索二维矩阵 II](../problem240/README.md)

时间复杂度 O(m + n)