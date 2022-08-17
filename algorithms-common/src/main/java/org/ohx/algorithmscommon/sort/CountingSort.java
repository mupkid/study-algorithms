package org.ohx.algorithmscommon.sort;

import java.util.Objects;

/**
 * 计数排序
 *
 * @author mudkip
 * @date 2022/8/17
 */
public class CountingSort {
    public static void countingSort(int[] a) {
        if (Objects.isNull(a) || a.length < 2) {
            return;
        }

        int max = a[0];
        for (int k : a) {
            if (max < k) {
                max = k;
            }
        }

        int[] c = new int[max + 1];
        for (int j : a) {
            c[j]++;
        }
        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }

        int[] r = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        System.arraycopy(r, 0, a, 0, r.length);
    }
}
