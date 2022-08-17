package org.ohx.algorithmscommon.sort;

/**
 * @author mudkip
 * @date 2022/8/17
 */
public class SelectionSort {
    public static void selectionSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}
