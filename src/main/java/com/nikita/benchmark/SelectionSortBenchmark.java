package com.nikita.benchmark;

import com.nikita.algorithms.SelectionSort;
import com.nikita.metrics.PerformanceTracker;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(1)
@State(Scope.Thread)
public class SelectionSortBenchmark {

    @Param({"100", "1000", "5000"})
    private int n;

    private int[] arr;
    private PerformanceTracker tracker;

    @Setup(Level.Invocation)
    public void setup() {
        Random random = new Random(42);
        arr = random.ints(n, 0, n).toArray();
        tracker = new PerformanceTracker();
    }

    @Benchmark
    public void selectionSortBenchmark() {
        int[] copy = Arrays.copyOf(arr, arr.length);
        SelectionSort sort = new SelectionSort(tracker);
        tracker.start();
        sort.sort(copy);
        tracker.stop();
    }
}
