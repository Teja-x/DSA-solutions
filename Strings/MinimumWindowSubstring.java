/* 
Problem    : Minimum Window Substring
LeetCode   : https://leetcode.com/problems/minimum-window-substring/
Approach   : Sliding Window + Frequency Count
-------------------------------------------------------------------------------------
- Goal: Find the smallest window in `s` that contains all characters of `t`.
- Use two pointers (`left` and `right`) to form a sliding window.
- Maintain a `tFreq[]` array to track required character frequencies.
- On expanding the window to the right, decrease `tFreq[c]`.
  - If `tFreq[c]` was > 0 before decrementing, it means it's a needed char — increment `have`.
- Once all required chars are included (`have == t.length()`), try shrinking from the left one by one while the condition is still valid.
- Track and update the best (smallest) valid window.

Key Insight:
- `tFreq` acts as a balance sheet. Negative values indicate extra chars in window, 
  positive values mean still needed. 
- Only when all needed chars are balanced (zero or negative), we try shrinking.

Time Complexity   : O(n1 + n2) → n1 = s.length(), n2 = t.length()
Space Complexity  : O(128) → O(1) constant space for ASCII

Example:
Input  : s = "ADOBECODEBANC", t = "ABC"
Output : "BANC"

Author: Teja Nayani  
Date  : September 15, 2025
*/

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int left= 0, right =0, have = 0;
        int n1 = s.length(), n2 = t.length();
        if(n1 < n2){
            return "";
        }
        int bestL = 0, bestR = 0;
        int bestLen = Integer.MAX_VALUE;
        int[] tFreq = new int[128];
        for(int i = 0; i < n2; i++){
            tFreq[t.charAt(i)]++;
        }
        for(right = 0; right < n1; right++){
            char c1 = s.charAt(right);

            if(tFreq[c1] > 0){
                have++;
            }
            tFreq[c1]--;

            while(have == n2){
                int winLen = right-left +1;
                if(winLen < bestLen){
                    bestL = left;
                    bestR = right+1;
                    bestLen = winLen;
                }
                int lc = s.charAt(left); //lc - left character being shrinked
                tFreq[lc]++;
                if(tFreq[lc] > 0){
                    have--;
                }
                left++;
            }
        }
        return (bestLen == Integer.MAX_VALUE) ? "" : s.substring(bestL, bestR); 
    }
}
