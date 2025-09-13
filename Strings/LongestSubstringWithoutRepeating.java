/*
Problem: Longest Substring Without Repeating Characters  
LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Approach: Sliding Window + Last Seen Index Tracking  
---------------------------------------------------
- Maintain a sliding window [start, end] where all characters are unique.
- Use an array `lastSeen` of size 128 (for ASCII) to store the last index of each character.
- While traversing the string:
  - If the current character was seen **after or at `start`**, update `start` to `lastSeen[ch] + 1`
  - Update the `lastSeen` index of the character.
  - Calculate the current window length and update `max`.

Optimizations:
- Uses an int[128] instead of HashMap for faster lookups on ASCII characters.
- Also includes a commented HashMap version for extended Unicode support.

Time Complexity: O(n)  
Space Complexity: O(128) ≈ O(1)

Example:
Input  : s = "abcabcbb"  
Output : 3  
Explanation: The answer is "abc", with the length of 3.

Author: Teja Nayani  
Date  : September 13, 2025
*/

class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, max = 0;
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        for(int end = 0; end < s.length(); end++){
            int ch = s.charAt(end);
            // if(lastSeen[ch] != -1){
            //     start = Math.max(start, lastSeen[ch]+1);
            // }
            if(lastSeen[ch] >= start){
                start = lastSeen[ch]+1;
            }
            lastSeen[ch] = end;
            max = Math.max(max, end-start+1);
        }

        /* Using HashMap
        Map<Character, Integer> lastSeen = new HashMap<>();
        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            if(lastSeen.containsKey(ch)){
                start = Math.max(start, lastSeen.get(ch)+1);
            }
            lastSeen.put(ch, end);
            max = Math.max(max, end-start+1);
        }*/
        return max;
    }
}