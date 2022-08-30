package org.ohx.algorithmscommon.tree;

/**
 * 二叉搜索树
 *
 * @author mudkip
 * @date 2022/8/30
 */
public class BinarySearchTree<T extends Comparable<T>> {
    /**
     * 使用非递归实现二叉搜索树查找
     *
     * @param root BST根节点引用
     * @param key  待查找的节点值
     * @return 命中的节点
     */
    public BsTreeNode<T> search(BsTreeNode<T> root, T key) {
        if (root == null) {
            return null;
        }

        BsTreeNode<T> p = root;
        while (p != null) {
            if (p.value.compareTo(key) > 0) {
                p = p.left;
            } else if (p.value.compareTo(key) < 0) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 使用递归实现二叉搜索树查找
     *
     * @param root BST根节点引用
     * @param key  待查找的节点值
     * @return 命中的节点
     */
    public BsTreeNode<T> searchRecursively(BsTreeNode<T> root, T key) {
        if (root == null) {
            return null;
        }

        if (root.value.compareTo(key) == 0) {
            return root;
        } else if (root.value.compareTo(key) > 0) {
            return searchRecursively(root.left, key);
        } else {
            return searchRecursively(root.right, key);
        }
    }

    public boolean insert(BsTreeNode<T> root, T value) {
        return insert(root, new BsTreeNode<>(value));
    }

    public boolean insert(BsTreeNode<T> root, BsTreeNode<T> nodeInserted) {
        if (root == null) {
            root = nodeInserted;
            return true;
        }

        BsTreeNode<T> p = root;
        while (true) {
            if (p.value.compareTo(nodeInserted.value) > 0) {
                if (p.left == null) {
                    p.left = nodeInserted;
                    nodeInserted.parent = p;
                    return true;
                } else {
                    p = p.left;
                }
            } else if (p.value.compareTo(nodeInserted.value) < 0) {
                if (p.right == null) {
                    p.right = nodeInserted;
                    nodeInserted.parent = p;
                    return true;
                } else {
                    p = p.right;
                }
            } else {
                return false;
            }
        }
    }

    public boolean insertRecursively(BsTreeNode<T> root, T value) {
        return insertRecursively(root, new BsTreeNode<>(value));
    }

    public boolean insertRecursively(BsTreeNode<T> root, BsTreeNode<T> nodeInserted) {
        if (root == null) {
            root = nodeInserted;
            return true;
        }

        if (root.value.compareTo(nodeInserted.value) > 0) {
            if (root.left == null) {
                root.left = nodeInserted;
                nodeInserted.parent = root;
                return true;
            } else {
                return insertRecursively(root.left, nodeInserted);
            }
        } else if (root.value.compareTo(nodeInserted.value) < 0) {
            if (root.right == null) {
                root.right = nodeInserted;
                nodeInserted.parent = root;
                return true;
            } else {
                return insertRecursively(root.right, nodeInserted);
            }
        } else {
            return false;
        }
    }

    /**
     * 删除节点
     *
     * @param root BST根节点引用
     * @param value 待删除的节点值
     * @return 删除后的新BST根节点引用
     */
    public BsTreeNode<T> delete(BsTreeNode<T> root, T value) {
        // p 指向要删除的节点，初始化指向根节点
        BsTreeNode<T> p = root;
        // pp 记录 p 的父节点
        BsTreeNode<T> pp = null;
        while (p != null && p.value != value) {
            pp = p;
            if (p.value.compareTo(value) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        // 没有找到要删除的节点，返回
        if (p == null) {
            return root;
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            // 查找右子树中的最小节点，即要删除节点的中序直接后继
            BsTreeNode<T> minP = p.right;
            // minP 的父节点
            BsTreeNode<T> minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 用中序直接后继替换掉被删除节点
            p.value = minP.value;
            // 然后问题转成删除该中序直接后继节点
            p = minP;
            pp = minPP;
        }

        // 要删除节点是叶子节点或者只有一个子节点
        // p 的子节点
        BsTreeNode<T> child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }
        if (pp == null) {
            return child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
        return root;
    }

    public void deleteRecursively(BsTreeNode<T> root, T value) {
        if (root == null) {
            return;
        }

        if (root.value.compareTo(value) > 0) {
            deleteRecursively(root.left, value);
        } else if (root.value.compareTo(value) < 0) {
            deleteRecursively(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                BsTreeNode<T> parent = root.parent;
                if (parent.left == root) {
                    parent.left = null;
                }
                if (parent.right == root) {
                    parent.right = null;
                }
            } else if (root.left != null && root.right != null) {
                // 找到当前节点的的中序前驱节点
                BsTreeNode<T> node = root.left;
                while (node.right != null) {
                    node = node.right;
                }

                // 节点内容替换
                root.value = node.value;
                // 删除前驱节点
                deleteRecursively(node, node.value);
            } else {
                BsTreeNode<T> node = root.left == null ? root.right : root.left;
                root.left = node.left;
                root.right = node.right;
                root.value = node.value;

                // 修正引用
                if (root.left != null) {
                    root.left.parent = root;
                }
                if (root.right != null) {
                    root.right.parent = root;
                }
            }
        }
    }

    static class BsTreeNode<T extends Comparable<T>> {
        /**
         * 关键字（键值）
         */
        T value;

        /**
         * 左节点引用
         */
        BsTreeNode<T> left;

        /**
         * 右节点引用
         */
        BsTreeNode<T> right;

        /**
         * 父节点引用
         */
        BsTreeNode<T> parent;

        public BsTreeNode() {
        }

        public BsTreeNode(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
