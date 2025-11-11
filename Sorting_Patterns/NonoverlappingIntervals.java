/*
Problem     : Non-overlapping Intervals  
LeetCode    : https://leetcode.com/problems/non-overlapping-intervals/

Goal:
Given a collection of intervals, find the minimum number of intervals 
you need to remove so that the rest of the intervals do not overlap.

Explanation:
----------------------------------------------------
1) Sort all intervals by their start time.

2) Initialize:
   - `prev` → first interval (as the reference interval)
   - `count` → to count how many intervals need removal

3) Iterate through each interval:
   - If `curr[0] < prev[1]` → overlap detected:
        → Increment `count` (since one interval must be removed)
        → Keep the interval with the **smaller end time** (greedy choice)
          because it allows more room for future non-overlapping intervals.
          i.e. `prev[1] = min(prev[1], curr[1])`
   - Else → no overlap:
        → Move `prev` to `curr` (safe to keep it)

4) Return `count` (minimum number of intervals removed).

Why It Works:
- Sorting ensures all intervals are processed in order.
- Choosing the interval with smaller end time maximizes the number of intervals retained.

Time Complexity : O(n log n)  (for sorting)
Space Complexity: O(1)

Author: Teja Nayani  
Date  : 9 November, 2025
*/

import java.util.Arrays;

public class NonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int[] prev = intervals[0];
        int count = 0;

        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] < prev[1]){
                prev[1] = Math.min(prev[1], curr[1]);
                count++;
            }else{
                prev = curr;
            }
        }
        return count;
    }
}
