package org.ohx.algorithmscommon;

import org.junit.jupiter.api.Test;
import org.ohx.algorithmscommon.sort.InsertionSort;
import org.ohx.algorithmscommon.sort.MergeSort;
import org.ohx.algorithmscommon.sort.QuickSort;

import java.util.Arrays;

/**
 * @author mudkip
 * @date 2022/8/17
 */
public class SortTest {
    @Test
    public void insertionTest() {
        int[] a = new int[]{8, 3, 9, 7, 1, 2, 5};
        System.out.println("排序前：" + Arrays.toString(a));
        InsertionSort.insertionSort(a);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    @Test
    public void mergeSortTest() {
        int[] a = new int[]{8, 3, 9, 7, 1, 2, 5};
        System.out.println("排序前：" + Arrays.toString(a));
        MergeSort.mergeSort(a);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    @Test
    public void quickSortTest() {
        int[] a = new int[]{6, 8, 7, 6, 3, 5, 9, 4};
        System.out.println("排序前：" + Arrays.toString(a));
        QuickSort.quickSort(a);
        System.out.println("排序后：" + Arrays.toString(a));
    }
}
