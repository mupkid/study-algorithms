# [934. 最短的桥](https://leetcode.cn/problems/shortest-bridge/)

给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。

岛是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中恰好存在两座岛。

你可以将任意数量的 0 变为 1，以使两座岛连接起来，变成一座岛。

返回必须翻转的 0 的最小数目。

提示：

* n == grid.length == grid[i].length
* 2 <= n <= 100
* grid[i][j] 为 0 或 1
* grid 中恰有两个岛
