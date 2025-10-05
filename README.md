Deterministic and Classic Sorting Algorithms – Benchmark Project

Overview

This project is part of the Design and Analysis of Algorithms (DAA) Assignment 2.  
It implements and benchmarks algorithms to analyze their performance across different input types and sizes.

My implementation focuses on the Selection Sort algorithm, while my teammate implemented Insertion Sort for comparison.

Implemented Algorithm
Selection Sort

Selection Sort repeatedly finds the minimum element from the unsorted part of the array and places it at the beginning.  
It is simple but inefficient for large datasets with time complexity O(n²).

Key Metrics Collected:
- Execution time (milliseconds)
- Number of comparisons
- Number of swaps


Benchmark Results

| Type      | n     | Time (ms) | Comparisons | Swaps |
|------------|-------|-----------|--------------|-------|
| Random     | 100   | 0.159 | 4170 | 59 |
| Random     | 1000  | 3.846 | 300735 | 368 |
| Random     | 5000  | 1.829 | 1042209 | 212 |
| Random     | 10000 | 39.383 | 49292295 | 8813 |
| Sorted     | 10000 | 0.004 | 9999 | 0 |
| Reversed   | 10000 | 45.352 | 37502499 | 5000 |

Selection Sort performs very well on already sorted data, but poorly on reversed or random data due to the large number of comparisons.


Steps Taken

1. Algorithm Implementation  
   Implemented the Selection Sort algorithm with detailed tracking of comparisons and swaps.

2. Performance Measurement  
   Created a `PerformanceTracker` class to record runtime in milliseconds, as well as operation counts.

3. Benchmark Runner
   Developed `BenchmarkRunner` to generate different types of input arrays (random, sorted, reversed) and measure performance for various sizes.

4. CSV Output
   Wrote all benchmark results into a `.csv` file for further analysis and visualization.

5. Validation and Debugging 
   Verified timing precision (in fractional milliseconds) and tested output correctness.

6. Documentation
   Prepared this `README.md` and a comparison summary in `docs/` folder for submission.