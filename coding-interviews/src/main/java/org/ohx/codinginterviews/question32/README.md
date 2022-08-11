# 面试题32：从上往下打印二叉树
> 题目一：不分行从上到下打印二叉树。从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

> 题目二：分行从上到下打印二叉树。从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

> 题目三：之字形打印二叉树。请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二行按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

标签：`树`

## 1 树的广度遍历
不难发现，这是一个先进先出的情况，因此可以借助队列完成。