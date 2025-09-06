/*
Problem: Valid Anagram
Link: https://leetcode.com/problems/valid-anagram/

Approach:
- Count frequency of each character using a fixed-size array of length 26 (for lowercase English letters).
- Increment count for characters in string `s`, decrement for characters in string `t`.
- If both strings are anagrams, all array values will end at 0.

Time Complexity: O(n)
- Where n = length of the strings. One pass to count, one pass to verify.

Space Complexity: O(1)
- Only a fixed-size array of 26 is used (constant space), regardless of input size.

Alternative Approaches:
1. Sorting both strings and comparing (O(n log n) time).
2. Using HashMap<Character, Integer> for general Unicode character handling.

Note:
- Assumes strings contain only lowercase English letters ('a'–'z').
- More space/time efficient than the sorting and HashMap approaches.

Author: Teja Nayani
Date: September 4, 2025
*/

class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        /* convert both strings to character arrays, sort the arrays and compare
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        if(sArr.length != tArr.length){
            return false;
        }

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for(int i = 0; i < sArr.length; i++){
            if(sArr[i] != tArr[i]){
                return false;
            }
        }
        return true;
        */

        /* use HashMap<Character, Integer> to simultaneously increment the character(key) count(value) of string s by 1 and decrement the character(key) count(value) of string t by -1 
        
        if(s.length() != t.length()){
            return false;
        }

        HashMap <Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            hm.put(s.charAt(i) , hm.getOrDefault(s.charAt(i), 0) + 1);
            hm.put(t.charAt(i) , hm.getOrDefault(t.charAt(i), 0) - 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(hm.get(s.charAt(i)) != 0){
                return false;
            }
        }
        return true;
        */
        
        //using a single count array to simultaneously increment character count of strings s and decrement the character count of string t
        int[] countArr = new int[26];

        if(s.length()!=t.length()){
            return false;
        }

    
        for(int i = 0; i < s.length(); i++){
            countArr[s.charAt(i) - 'a']++;
            countArr[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(countArr[i] != 0){
                return false;
            }
        }
        return true;

    }
}