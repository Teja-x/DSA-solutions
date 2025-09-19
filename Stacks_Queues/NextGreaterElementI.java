/*
Problem     : Next Greater Element I  
LeetCode    : https://leetcode.com/problems/next-greater-element-i/  
Approach    : Monotonic Stack + HashMap  
-----------------------------------------------------
Goal        : 
- For each element in nums1, find the first greater element in nums2 (which is a superset of nums1) to its right.
- If not found, return -1.

Intuition   : 
- This is a **Next Greater Element to the Right (NGR)** problem.
- We process `nums2[]` using a **monotonic decreasing stack**:
    → If current number is greater than the element at top of stack, we pop and store the NGE mapping in a HashMap.
    → Else, we push the current number into the stack.
- Finally, for each number in `nums1[]`, we just look up its mapping from the HashMap. If not found, answer is -1.

Why HashMap?
- Because `nums1[]` is a subset of `nums2[]`, and the mapping is built for every element in `nums2[]`.
- So we can answer each `nums1[i]` in O(1) lookup.

Time Complexity   : O(n + m)  
    - n = length of nums2 → to build map with stack.
    - m = length of nums1 → to generate final output.

Space Complexity  : O(n) for stack + map.

Example:  
Input : nums1 = [4,1,2], nums2 = [1,3,4,2]  
Output: [-1,3,-1]  
(4→no greater, 1→3, 2→no greater)

Author: Teja Nayani  
Date  : September 18, 2025  
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> minStack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums2.length; i++){
            while(!minStack.isEmpty() && nums2[i] > minStack.peek()){
                int top = minStack.pop();
                map.put(top, nums2[i]);
            }
            minStack.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
