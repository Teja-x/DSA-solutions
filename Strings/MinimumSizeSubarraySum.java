/*
Problem    : Minimum Size Subarray Sum
LeetCode   : https://leetcode.com/problems/minimum-size-subarray-sum/

Approach   : Sliding Window (Two-Pointer Technique)
-----------------------------------------------------
Goal       : Find the minimal length of a contiguous subarray
             of which the sum ≥ target. Return 0 if no such subarray exists.

- Use two pointers: `left` and `right` to form a window.
- Expand the window by moving `right` and adding `nums[right]` to `winSum`.
- Once `winSum` ≥ target:
    • Update the minimum length.
    • While maintaining window validity - shrink the window from the left by moving `left` and subtracting `nums[left]` from `winSum`.
- Repeat until the entire array is processed.

Time Complexity   : O(n) — Each element is visited at most twice (once by `right`, once by `left`)
Space Complexity  : O(1) — No extra space used

Example:
Input  : target = 7, nums = [2,3,1,2,4,3]
Output : 2 → The subarray [4,3] has the minimal length under the problem constraint.

Author: Teja Nayani  
Date  : September 16, 2025
*/

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, n = nums.length;
        int winSum = 0, min = Integer.MAX_VALUE;
        while(right < n){
            winSum += nums[right];
            while(winSum >= target){
                min = Math.min(min, (right-left+1));
                winSum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;        
    }
}
