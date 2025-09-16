/*
Problem    : Permutation in String  
LeetCode   : https://leetcode.com/problems/permutation-in-string/

Approach   : Sliding Window + Frequency Array  
----------------------------------------------------
- Goal: Check if one string’s permutation is a substring of another string.
- If `s1`’s length (`n1`) is greater than `s2`’s length (`n2`), return false immediately.
- Create a frequency array `freq[26]` counting characters in `s1`.
- Slide a window of size `n1` over `s2`:
    • For each new character entering window at `right`, decrement its freq; if it was > 0 before decrement, increment `have`.  
    • If the window becomes larger than `n1`, shrink from `left`: restore frequency and adjust `have` if necessary.
- If at any point `have == n1`, it means window contains exactly all chars of `s1` (a permutation) → return true.

Time Complexity   : O(n2) where n2 = length of `s2`  
Space Complexity  : O(26) → O(1) constant space for character frequency

Example:
Input  : s1 = "ab", s2 = "eidbaooo"  
Output : true  (because “ba” is a permutation of “ab” and occurs in `s2`)

Author: Teja Nayani  
Date  : September 15, 2025
*/

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if(n1 > n2)
            return false;
        int left = 0, right = 0, have = 0;
        int freq[] = new int[26];
        for(int i = 0; i < n1; i++){
            freq[s1.charAt(i)-'a']++;
        }
        for(right = 0; right < n2; right++){
            int rc = s2.charAt(right) - 'a';

            if(freq[rc] > 0){
                have++;
            }
            freq[rc]--;
            
            if(right-left+1 > n1){
                    int lc = s2.charAt(left)-'a';
                    freq[lc]++;
                    if(freq[lc] > 0){
                        have--;
                    }
                    left++;
            }
            if(have == n1)
                return true;
        }
        return false;
    }
}