package org.ohx.algorithmscommon.sort;

/**
 * 冒泡排序
 *
 * @author mudkip
 * @date 2022/8/17
 */
public class BubblleSort {
    /**
     * 冒泡排序
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
