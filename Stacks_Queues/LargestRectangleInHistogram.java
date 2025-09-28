/*
Problem    : Largest Rectangle in Histogram
LeetCode   : https://leetcode.com/problems/largest-rectangle-in-histogram/

Goal       : Given an array `heights[]` representing histogram bar heights,
             find the area of the largest rectangle that can be formed.

Approach   : Monotonic Increasing Stack
----------------------------------------------------
- Maintain a stack of indices where bar heights are in increasing order.
- Iterate through the array:
    • For each `heights[right]`, if it is smaller than the top of the stack:
        - Pop indices until the stack is valid.
        - Each pop calculates an area with height = popped bar.
        - Width = distance between current index `right` and the new top of stack.
    • Push current index onto stack if valid.
- Append an extra iteration with `0` height to ensure all bars are processed.

Why it Works?
- Every bar is pushed and popped at most once → O(n).
- The stack ensures we always know the left boundary for each popped bar.
- This avoids recomputation and covers all possible largest rectangles.

Time Complexity   : O(n)
    - Each element is processed once when pushed, once when popped.
Space Complexity  : O(n)
    - Stack can hold up to n indices in worst case.

Example:
Input  : [2,1,5,6,2,3]
Output : 10
Explanation: Rectangle between indices 2 and 3 → 5x2 = 10

Author   : Teja Nayani
Date     : September 23, 2025
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int largest = 0;
        int left, right, n = heights.length;
        int j, width, area;
        for(right = 0; right <= n; right++){
            int curr = (right == n) ? 0:heights[right]; 
            while(!stack.isEmpty() && curr < heights[stack.peek()]){
                j = stack.pop();
                left = stack.isEmpty() ? -1 : stack.peek();
                width = right-left-1;
                area = heights[j] * width;
                largest = Math.max(largest, area);
            }
            if(right < n)
                stack.push(right);
        }
        return largest;
    }
}
