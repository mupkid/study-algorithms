package org.ohx.algorithmscommon.sort;

import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/8/17
 */
public class QuickSort {
    public static void quickSort(int[] a) {
        if (Objects.isNull(a) || a.length == 0) {
            return;
        }

        quickSortC(a, 0, a.length - 1);
    }

    private static void quickSortC(int[] a, int front, int rear) {
        if (front >= rear) {
            return;
        }
        int middle = partition(a, front, rear);
        quickSortC(a, front, middle - 1);
        quickSortC(a, middle + 1, rear);
    }

    private static int partition(int[] a, int front, int rear) {
        int i = front;
        for (int j = front; j < rear; j++) {
            if (a[j] < a[rear]) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
        }
        int temp = a[i];
        a[i] = a[rear];
        a[rear] = temp;

        return i;
    }
}
