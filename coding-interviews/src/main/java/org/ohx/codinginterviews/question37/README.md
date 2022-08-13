# 面试题37：序列化二叉树
> 题目：请实现两个函数，分别用来序列化和反序列化二叉树

标签：`树`

## 1 前序遍历
```java
public class Solution {
    /**
     * 序列的下标
     */
    private int index = 0;

    private void SerializeFunction(TreeNode root, StringBuilder str) {
        // 如果节点为空，表示左子节点或右子节点为空，用#表示
        if (root == null) {
            str.append('#');
            return;
        }
        // 根节点
        str.append(root.val).append('!');
        // 左子树
        SerializeFunction(root.left, str);
        // 右子树
        SerializeFunction(root.right, str);
    }

    public String Serialize(TreeNode root) {
        // 处理空树
        if (root == null) {
            return "#";
        }
        StringBuilder res = new StringBuilder();
        SerializeFunction(root, res);
        // 把str转换成char
        return res.toString();
    }

    private TreeNode DeserializeFunction(String str) {
        // 到达叶节点时，构建完毕，返回继续构建父节点
        // 空节点
        if (str.charAt(index) == '#') {
            index++;
            return null;
        }
        // 数字转换
        int val = 0;
        // 遇到分隔符或者结尾
        while (str.charAt(index) != '!') {
            val = val * 10 + ((str.charAt(index)) - '0');
            index++;
        }
        TreeNode root = new TreeNode(val);
        index++;
        // 反序列化与序列化一致，都是前序
        root.left = DeserializeFunction(str);
        root.right = DeserializeFunction(str);
        return root;
    }

    public TreeNode Deserialize(String str) {
        // 空序列对应空树
        if (Objects.equals(str, "#")) {
            return null;
        }
        return DeserializeFunction(str);
    }
}
```

## 2 广度遍历/层序遍历
```java
public class Solution {
    public String Serialize(TreeNode root) {
        // 根节点为null，返回空字符串
        if (Objects.isNull(root)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 常规的广度遍历，左右子节点不需要判空
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Objects.isNull(node)) {
                sb.append("#").append(",");
                continue;
            }
            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return sb.toString();
    }

    public TreeNode Deserialize(String str) {
        // 空字符串，返回null
        if (Objects.isNull(str) || str.length() < 1) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int i = 1;
        // 同样是广度遍历
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 构建左节点
            if (!"#".equals(nodes[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                node.left = left;
                // 入队
                queue.offer(left);
            }
            i++;
            // 构建右节点
            if (!"#".equals(nodes[i])) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                node.right = right;
                // 入队
                queue.offer(right);
            }
            i++;
        }

        return root;
    }
}
```