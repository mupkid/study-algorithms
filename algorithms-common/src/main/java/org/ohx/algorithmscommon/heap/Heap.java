package org.ohx.algorithmscommon.heap;

/**
 * 大顶堆
 *
 * @author mudkip
 * @date 2022/8/16
 */
public class Heap {
    /**
     * 堆是一棵完全二叉树，而完全二叉树很适合用数组存储。因此堆使用数组存储数据，从下标1开始存储结构
     */
    private final int[] a;

    /**
     * 堆可以存储的最大的数据个数
     */
    private final int n;

    /**
     * 堆中已经存储的数据个数
     */
    private int count;

    public Heap(int capacity) {
        this.a = new int[capacity + 1];
        this.n = capacity;
        count = 0;
    }

    /**
     * 往堆中添加元素
     *
     * @param data 新元素
     */
    public void insert(int data) {
        if (count >= n) {
            // 栈满，退出
            return;
        }

        // 新元素放到末尾
        ++count;
        a[count] = data;
        // 自下而上的堆化
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            int temp = a[i];
            a[i] = a[i / 2];
            a[i / 2] = temp;
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 堆排序
     *
     * @param a 不符合堆条件的数组
     * @param n 数组的长度
     */
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            int temp = a[1];
            a[1] = a[k];
            a[k] = temp;
            k--;
            heapify(a, k, 1);
        }
    }

    /**
     * 建堆，把不符合堆条件的数组变成堆
     *
     * @param a 不符合堆条件的数组
     * @param n 数组的长度
     */
    private static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * 自上而下的堆化
     *
     * @param a 数组，即堆
     * @param n 数组的最大长度
     * @param i 需要调整的元素在数组中的下标
     */
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            // 父节点与左右子节点大小比较后，最大的节点的下标
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 < n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                // 父节点就是最大的，不需要交换，退出
                break;
            }

            // 交换
            int temp = a[i];
            a[i] = a[maxPos];
            a[maxPos] = temp;

            // 走到下一层
            i = maxPos;
        }
    }
}
