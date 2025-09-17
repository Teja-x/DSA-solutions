/* 
Problem    : Longest Subarray of 1's After Deleting One Element  
LeetCode   : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

Approach   : Sliding Window + Frequency Array
-----------------------------------------------------
Goal       : Find the length of the longest subarray containing only 1's 
             after deleting exactly one element(0).

- Use a sliding window using two pointer `left` and `right` to track a valid window with at most **one 0**.
- Expand right and maintain a frequency count array `freq` to track number of 0s and 1s in the window.
- If the number of 0s exceeds 1, shrink the window from the left
- At every step, update the max length using the count of 1s in the window (excluding the deleted 0).
- Finally, return the `longest` length. If the array contains all 1s, the answer should be `n - 1` since we must delete one element.

Time Complexity   : O(n) — Each element is processed at most twice (once by right, once by left).
Space Complexity  : O(1) — Frequency array of fixed size (2).

Example:
Input  : nums = [1,1,0,1]
Output : 3 → We can delete the 0 to get subarray [1,1,1]

Author: Teja Nayani  
Date  : September 17, 2025
*/

public class LongestSubarrayOf1s {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, longest = 0, n = nums.length;
        int[] freq = new int[2];
        while(right < n){
            int ele = nums[right];
            freq[ele]++;
            while(freq[0] > 1){
                int leftEle = nums[left];
                freq[leftEle]--;
                left++;
            }
            longest = Math.max(longest, freq[1]);
            right++;
        } 
        return freq[1] == n ? n-1 : longest;
    }
}
