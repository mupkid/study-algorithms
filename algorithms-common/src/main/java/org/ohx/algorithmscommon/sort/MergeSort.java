package org.ohx.algorithmscommon.sort;

import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/8/17
 */
public class MergeSort {
    public static void mergeSort(int[] a) {
        if (Objects.isNull(a) || a.length == 0) {
            return;
        }

        mergeSortC(a, 0, a.length - 1);
    }

    private static void mergeSortC(int[] a, int front, int rear) {
        if (front >= rear) {
            return;
        }

        int middle = (front + rear) / 2;
        mergeSortC(a, front, middle);
        mergeSortC(a, middle + 1, rear);

        merge(a, front, middle, rear);
    }

    private static void merge(int[] a, int front, int middle, int rear) {
        // 申请辅助空间并赋值
        int[] tempLeft = new int[middle - front + 2];
        int[] tempRight = new int[rear - middle + 1];
        System.arraycopy(a, front, tempLeft, 0, middle - front + 1);
        // 哨兵
        tempLeft[middle - front + 1] = Integer.MAX_VALUE;
        System.arraycopy(a, middle + 1, tempRight, 0, rear - middle);
        // 哨兵
        tempRight[rear - middle] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = front;
        while (k <= rear) {
            if (tempLeft[i] <= tempRight[j]) {
                a[k++] = tempLeft[i++];
            } else {
                a[k++] = tempRight[j++];
            }
        }
    }
}
