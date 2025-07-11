# [146. LRU 缓存](https://leetcode.cn/problems/lru-cache/)

## 思路

LRU 算法的几个操作

1. 把访问过的元素快速放到头部，这个元素可以是新访问的，也可以是已经前不久访问过的
2. 把尾部最后一个元素移除

根据这些操作，可以分析：

* 不能使用数组（线性结构），因为取出元素、删除元素时需要移动其他元素，达不到 O(1)。
* 这样就只能使用链表（非线性结构），取出元素、删除元素时，只需要修改相应元素的指针即可。
* 要删除尾节点，需要有一个 tail 指针指向链表最后一个元素。
* 如果访问到链表内的元素，需要把这个元素拿出来放到头部，这时候需要直到这个节点的前一个节点来修改指针，所以要快速找到这个节点，我们需要每个节点都有 prev 指针指向上一个节点，因此得到双向链表

```java
class LRUCache {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;

    private final Node dummy = new Node(0, 0);

    private final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }

        // 新书
        node = new Node(key, value);
        keyToNode.put(key, node);
        // 放在最上面
        pushFront(node);
        if (keyToNode.size() > capacity) {
            // 书太多了，去掉最底部的书
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) {
            return null;
        }
        Node node = keyToNode.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }
}
```

使用 LinkedHashMap

```java
class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = cache.remove(key);
        if (value != null) {
            cache.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.remove(key) != null) {
            cache.put(key, value);
            return;
        }

        if (cache.size() == capacity) {
            Integer eldestKey = cache.keySet().iterator().next();
            cache.remove(eldestKey);
        }
        cache.put(key, value);
    }
}
```