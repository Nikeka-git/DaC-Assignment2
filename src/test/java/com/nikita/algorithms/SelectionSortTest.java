package com.nikita.algorithms;

import com.nikita.metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {
    @Test
    public void testRandomArray() {
        int[] arr = {5, 1, 4, 2, 8};
        int[] sorted = {1, 2, 4, 5, 8};

        SelectionSort s = new SelectionSort(new PerformanceTracker());
        s.sort(arr);

        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        SelectionSort s = new SelectionSort(new PerformanceTracker());
        s.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {1};
        SelectionSort s = new SelectionSort(new PerformanceTracker());
        s.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        SelectionSort s = new SelectionSort(new PerformanceTracker());
        s.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }
}
