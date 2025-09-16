/*
Problem    : Find All Anagrams in a String  
LeetCode   : https://leetcode.com/problems/find-all-anagrams-in-a-string/

Approach   : Sliding Window + Frequency Array  
----------------------------------------------------
- If `s1`’s length (`n1`) is greater than `s2`’s length (`n2`), return false immediately.
- Create a frequency array `freq[26]` counting characters in `s1`.
- Slide a window of size `n1` over `s2`:
    • For each new character entering window at `right`, decrement its freq; if it was > 0 before decrement, increment `have`.  
    • If the window becomes larger than `n1`, shrink from `left`: restore frequency and adjust `have` if necessary.
- If at any point `have == n1`, it means window contains exactly all chars of `s1` (a permutation) → add `left` index to the list indicating it's the start of anagram.

Time Complexity   : O(n1)  
Space Complexity  : O(1)  

Example:
Input  : s = "cbaebabacd", p = "abc"  
Output : [0, 6]  (Anagrams at indices 0 ("cba") and 6 ("bac"))

Date  : September 15, 2025
*/

class FindAllAnagramsInAString{
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int n1 = s.length(), n2 = p.length();
        if(n1 < n2)
            return list;
        int left = 0, right = 0, have = 0;

        int[] freq = new int[26];
        for(int i = 0; i < n2; i++)
            freq[p.charAt(i)-'a']++;

        while(right < n1){
            int rc = s.charAt(right)-'a';
            if(freq[rc] > 0)
                have++;
            freq[rc]--;
            right++;

            if(right-left > n2){
                int lc = s.charAt(left)-'a';
                freq[lc]++;
                if(freq[lc] > 0){
                    have--;
                }
                left++;
            }
            if(have == n2){
                list.add(left);
            }
        }
        return list;
    }
}