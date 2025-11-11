/*
Problem     : Minimum Number of Arrows to Burst Balloons
LeetCode    : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

Goal:
Given a set of intervals (balloons), find the minimum number of arrows 
required to burst all balloons. Each arrow can burst all balloons 
that overlap in range (i.e., share any x-coordinate).

Approach : Greedy (Sort by End Points)
----------------------------------------------------
1) Sort the balloons by their end coordinate.
   - This allows us to always shoot the arrow at the end of the current cluster,
     ensuring maximum balloons are burst with one arrow.

2) Initialize:
   - `arrows = 1` (since at least one arrow is needed)
   - `end = points[0][1]` (end position of the first balloon)

3) Iterate through each balloon:
   - If `points[i][0] > end` → current balloon starts after last arrow’s reach:
       → Need a new arrow.
       → Increment `arrows` and set `end = points[i][1]`
   - Else → overlapping balloon, already covered by the current arrow.

4) Return `arrows` as the minimum number of arrows required.

Why It Works:
- Sorting by end points ensures a greedy selection where each arrow is optimally placed 
  at the earliest possible end point that covers as many balloons as possible.

Time Complexity : O(n log n)  (due to sorting)
Space Complexity: O(1)

Author: Teja Nayani  
Date  : 10 November, 2025
*/

import java.util.Arrays;

public class MinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1;
        int end = points[0][1];
        
        //Greedy approach
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > end){ //new cluster of balloons i.e current arrow isn't enough to shoot the new cluster as new(start) > end)
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}
