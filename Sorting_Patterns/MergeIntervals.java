/*
Problem     : Merge Intervals  
LeetCode    : https://leetcode.com/problems/merge-intervals/

Goal:
Given an array of intervals where each interval[i] = [start_i, end_i],
merge all overlapping intervals and return an array of the non-overlapping intervals.

Explanation:
----------------------------------------------------
1) Sort the intervals based on their start time (ascending order).

2) Initialize:
   - `prev` → first interval (reference for comparison)
   - `result[][]` → to store merged intervals
   - `idx` → index tracker for result array

3) Iterate through each interval:
   - If current interval overlaps with previous (curr[0] ≤ prev[1]):
        Merge them by extending the end boundary:
            prev[1] = max(prev[1], curr[1])
   - Else:
        Add previous interval to result and move to the next one.

4) Add the last interval (`prev`) to the result.

5) Return a trimmed copy of the result array up to `idx`.

Why It Works:
- Sorting ensures all overlapping intervals appear next to each other.
- Merging consecutive overlapping intervals guarantees an O(n log n) + O(n) solution.

Time Complexity : O(n log n) (due to sorting)
Space Complexity: O(n) (for result array)

Author: Teja Nayani  
Date  : 9 November, 2025
*/

import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] result = new int[intervals.length][2];
        int prev[] = intervals[0];
        int idx = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] <= prev[1]){
                prev[1] = Math.max(prev[1], curr[1]);
            }else{
                result[idx++] = prev;
                prev = curr;
            }
        }
        result[idx++] = prev;
        return Arrays.copyOf(result, idx);
    }
}
