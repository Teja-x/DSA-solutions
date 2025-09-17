/*
Problem    : Longest Mountain in Array  
LeetCode   : https://leetcode.com/problems/longest-mountain-in-array/

Approach   : Expand around anchor (peak) + Two Pointers  
-----------------------------------------------------
Goal       : Find the length of the longest subarray that is a “mountain”, i.e. strictly increasing up to a peak and strictly decreasing after.

- Traverse the array with an index `idx` from 1 to n−2 (potential peaks).
- For each `idx` that satisfies `arr[idx] > arr[idx−1] && arr[idx] > arr[idx+1]` (a peak):
    • Expand to the left while values are strictly increasing.
    • Expand to the right while values are strictly decreasing.
    • Compute the length of this mountain = `right − left + 1`.
    • Skip ahead by setting `idx = right` to avoid reprocessing parts.
- Return 0 if no valid mountain found (need at least 3 elements to form a mountain).

Time Complexity   : O(n) — each element is processed at most a constant number of times due to skipping.
Space Complexity  : O(1) — only pointers and counters used.

Example:
Input  : arr = [2,1,4,7,3,2,5]
Output : 5  → Mountain is [1,4,7,3,2]

Author: Teja Nayani  
Date  : September 17, 2025
*/

public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int left, right, idx = 1, n = arr.length, longest = 0;
        while(idx < n-1){
            if((arr[idx] > arr[idx-1]) && (arr[idx] > arr[idx+1])){
                left = idx-1;
                right = idx+1;
                while(left > 0 && arr[left] > arr[left-1]){
                    left--;
                }
                while(right < n-1 && arr[right] > arr[right+1]){
                    right++;
                }
                longest = Math.max(longest, right-left+1);
                idx = right;
            }
            idx++;
        }
        return n >=3 ? longest : 0;
    }
}
