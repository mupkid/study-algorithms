package org.ohx.algorithmscommon.search;

import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/8/17
 */
public class BinarySearch {
    public static int binarySearch(int[] a, int n) {
        if (Objects.isNull(a) || a.length < 1) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) >> 2;
            if (a[mid] == n) {
                return mid;
            } else if (a[mid] > n) {
                high = mid - 1;
            } else if (a[mid] < n) {
                low = mid + 1;
            }
        }

        return -1;
    }
}
