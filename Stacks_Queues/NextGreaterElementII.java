/*
Problem    : Next Greater Element II
LeetCode   : https://leetcode.com/problems/next-greater-element-ii/

Goal       : Given a circular integer array, find the Next Greater Element (NGE) for every element.
             If no greater element exists, return -1 for that index.

Approach   : Monotonic Decreasing Stack + Circular Iteration
------------------------------------------------------------
- Use a stack to maintain indices of elements in decreasing order of value.
- Traverse the array twice (simulate circular behavior with `i % n`).
- For each element `nums[i % n]`:
    • While stack top < current element → pop and set result for popped index.
    • Push index if within the first pass (i < n).
- Initialize result with -1 (default for elements without NGE).

Why it Works?
- Stack ensures each element is matched with its "next greater".
- Doubling iteration handles wrap-around comparisons.
- Each element is pushed and popped at most once → O(n).

Time Complexity   : O(n)
    - Each element processed twice at most.
Space Complexity  : O(n)
    - Stack stores indices, result array of size n.

Example:
Input  : [1,2,1]
Output : [2,-1,2]

Author   : Teja Nayani
Date     : September 23, 2025
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> maxStack = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i < 2*n-1; i++){
            int curr = nums[i%n];
            while(!maxStack.isEmpty() && curr > nums[maxStack.peek()]){
                int idx = maxStack.pop();
                res[idx] = curr;
            }
            if(i < n){
                maxStack.push(i%n);
            }
        }
        return res;
    }
}
