/*
Problem     : Insert Interval  
LeetCode    : https://leetcode.com/problems/insert-interval/

Goal:
You are given a set of non-overlapping intervals sorted by start time.
Insert a new interval into the list (possibly merging overlapping intervals) 
and return the updated list of intervals.

Explanation:
----------------------------------------------------
1) Initialize:
   - `start`, `end` → boundaries of the new interval
   - `result[][]` → array to hold merged intervals
   - `i` → pointer for existing intervals
   - `idx` → index for result array

2) Step 1 → Add all non-overlapping intervals before `newInterval`:
   - While current interval ends before `start`, add it directly.

3) Step 2 → Merge all overlapping intervals:
   - While current interval starts ≤ `end`:
        Merge boundaries using:
        → start = min(start, intervals[i][0])
        → end   = max(end, intervals[i][1])
   - Add the merged interval once the overlapping ones are processed.

4) Step 3 → Add all remaining intervals (after the merged block).

5) Return:
   - A trimmed copy of result up to `idx`.

Why It Works:
- Since input intervals are already sorted, this single linear scan ensures
  all intervals are inserted and merged in O(n) time.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Teja Nayani  
Date  : 9 November, 2025
*/

import java.util.Arrays;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0, n = intervals.length;
        int[][] result = new int[n+1][2];
        int start = newInterval[0], end = newInterval[1];
        int idx = 0;

        while(i < n && intervals[i][1] < start){
            result[idx++] = intervals[i++];
        }
        while(i < n && intervals[i][0] <= end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result[idx++] = new int[]{start, end};

        while(i < n){
            result[idx++] = intervals[i++];
        }

        return Arrays.copyOf(result, idx);        
    }
}
