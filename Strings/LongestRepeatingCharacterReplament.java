/* 
Problem    : Longest Repeating Character Replacement
LeetCode   : https://leetcode.com/problems/longest-repeating-character-replacement/
Approach   : Sliding Window + Frequency Count
-------------------------------------------------------------------------------------
- Goal: Find the length of the longest substring that can be transformed into all 
  same characters with at most `k` replacements.
- Use a sliding window from `left` to `right` over the string.
- Maintain a `freq[26]` array to count occurrences of each character in current window.
- Track `maxFreq`, the count of the most frequent character in the current window.
- If window size - maxFreq > k, it means more than k changes are required, but we can perform only k(atmost), 
  so shrink the window from the left.

Key Insight:
- You don’t need to know which character is dominating — just how many characters 
  can be changed to match the most frequent one.

Time Complexity   : O(n) — each character is visited at most twice.
Space Complexity  : O(26) → O(1) — constant space for English uppercase letters.

Example:
Input  : s = "AABABBA", k = 1
Output : 4
Explanation: Replace the one 'A' in the middle to get "AABBBBA"

Author: Teja Nayani
Date  : September 14, 2025
*/

public class LongestRepeatingCharacterReplament {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxLen = 0, maxFreq = 0;
        for(int right = 0; right < s.length(); right++){

            int idx = s.charAt(right)-'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);

            while((right-left+1 - maxFreq) > k){ //shrink until the window is valid again
                // window fail - meaning the remaining elemets are more than k opretaions, which means even after performing k operations, there would still be remaining elements - which means it won't be longest substring containing ssame letter (as there are other letters) - so we need to shrink the window by moving left by one time to the right as to make window valid again.
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, (right-left+1));
        }
        return maxLen;
    }    
}
