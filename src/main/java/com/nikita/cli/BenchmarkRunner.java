package com.nikita.cli;

import com.nikita.algorithms.SelectionSort;
import com.nikita.metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        int[] sizes = {100, 1000, 5000, 10000};
        String[] types = {"random", "sorted", "reversed"};
        String outFile = "results/selectionsort.csv";

        try (FileWriter csv = new FileWriter(outFile)) {
            csv.write("type,n,time_ms,comparisons,swaps\n");

            for (String type : types) {
                for (int n : sizes) {
                    int[] arr = generateArray(n, type);
                    PerformanceTracker tracker = new PerformanceTracker();
                    SelectionSort sort = new SelectionSort(tracker);

                    tracker.start();
                    sort.sort(arr);
                    tracker.stop();

                    csv.write(String.format(Locale.US, "%s,%d,%.3f,%d,%d\n",
                            type, n, tracker.getTime(), tracker.getComparisons(), tracker.getSwaps()));
                    csv.flush();

                    System.out.printf("%s n=%d time=%.3fms comps=%d swaps=%d\n",
                            type, n, tracker.getTime(),
                            tracker.getComparisons(), tracker.getSwaps());
                }
            }
        }

        System.out.println("Results written to " + outFile);
    }

    private static int[] generateArray(int n, String type) {
        int[] arr = new Random().ints(n, 0, n).toArray();
        switch (type) {
            case "sorted" -> Arrays.sort(arr);
            case "reversed" -> {
                Arrays.sort(arr);
                for (int i = 0; i < n / 2; i++) {
                    int tmp = arr[i];
                    arr[i] = arr[n - i - 1];
                    arr[n - i - 1] = tmp;
                }
            }
        }
        return arr;
    }
}
