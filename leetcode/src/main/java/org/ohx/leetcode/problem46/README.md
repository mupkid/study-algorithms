# [46. 全排列](https://leetcode.cn/problems/permutations/description/)


`List<Integer> path = Arrays.asList(new Integer[nums.length]);` 和 `List<Integer> path = new ArrayList<>(nums.length);` 是有区别的：

* 前者是创建一个长度为 nums.length 的数组，然后把 nums 的元素复制到该数组中。
* 后者是创建一个长度为 nums.length 的 ArrayList，但是并不初始化元素，所以 `path.set(i, nums[j]);` 会抛出 IndexOutOfBoundsException。

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = Arrays.asList(new Integer[nums.length]);
        boolean[] onPath = new boolean[nums.length];
        dfs(0, nums, ans, path, onPath);
        return ans;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!onPath[j]) {
                path.set(i, nums[j]);
                onPath[j] = true;
                dfs(i + 1, nums, ans, path, onPath);
                onPath[j] = false;
            }
        }
    }
}
```

对比

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(nums.length);
        boolean[] onPath = new boolean[nums.length];
        dfs(0, nums, ans, path, onPath);
        return ans;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!onPath[j]) {
                path.add(nums[j]);
                onPath[j] = true;
                dfs(i + 1, nums, ans, path, onPath);
                path.remove(path.size() - 1);
                onPath[j] = false;
            }
        }
    }
}
```