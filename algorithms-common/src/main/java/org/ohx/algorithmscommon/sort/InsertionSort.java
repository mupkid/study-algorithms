package org.ohx.algorithmscommon.sort;

/**
 * 插入排序
 *
 * @author mudkip
 * @date 2022/8/17
 */
public class InsertionSort {
    /**
     * 插入排序
     *
     * @param a
     */
    public static void insertionSort(int[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            int value = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > value) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = value;
        }
    }

    public static void insertSort(int[] a) {
        int length = a.length;
        for (int i = 2; i < length; i++) {
            int j;
            // 哨兵
            a[0] = a[i];
            for (j = i - 1; a[j] > a[0]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = a[0];
        }
    }
}
