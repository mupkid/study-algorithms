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
            for (; j >= 0; j--) {
                if (value < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }
}
