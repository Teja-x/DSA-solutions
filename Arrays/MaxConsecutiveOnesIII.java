/*
Problem    : Max Consecutive Ones III  
LeetCode   : https://leetcode.com/problems/max-consecutive-ones-iii/

Approach   : Sliding Window with Frequency Counter  
-----------------------------------------------------
Goal       : Find the length of the longest subarray containing at most `k` zeroes by flipping them into ones.

- Use a sliding window with two pointers (`left`, `right`).
- Count the number of 0s and 1s in the current window using a `freq[]` array.
- If the count of 0s in the window exceeds `k`, shrink the window from the left until valid.
- Keep updating `max = max(max, right - left + 1)` to track the longest valid window length.

Time Complexity   : O(n) — each element is visited at most twice.
Space Complexity  : O(1) — fixed space for frequency array.

Example:
Input  : nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2  
Output : 6  → Flip 2 zeroes in [0,0,1,1,1,1] to get all 1s.

Author: Teja Nayani  
Date  : September 17, 2025
*/

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, max = 0, n = nums.length;
        int[] freq = new int[2];
        while(right < n){
            int re = nums[right];
            freq[re]++;
            while(freq[0] > k){
                int le = nums[left];
                freq[le]--;
                left++;
            }
            max = Math.max(max, right-left+1); //contains consecutives 0s and 1s in current valid window (or) max = Math.max(max, freq[0]+freq[1])
            right++;
        }
        return  max;
    }
}
