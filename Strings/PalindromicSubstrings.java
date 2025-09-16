/*
Problem: Palindromic Substrings  
LeetCode: https://leetcode.com/problems/palindromic-substrings/

Approach: Expand Around Center  
--------------------------------------------
- Goal: Count the number of palindromic substrings in the given string.
- Key Insight: A palindrome mirrors around its center.  
- There are 2n-1 possible centers in a string of length n:
    - n centers for odd-length palindromes (single character centers).
    - n-1 centers for even-length palindromes (between two characters).

Strategy:
- For each character in the string:
  - Expand around (i, i) to count all odd-length palindromes.
  - Expand around (i, i+1) to count all even-length palindromes.        
- Each expansion checks while `left >= 0`, `right < n`, and `s[left] == s[right]`.

Helper Method:
- `expandPalindrome(s, n, left, right)` returns the count of palindromes centered at (left, right).

Time Complexity: O(n²)  
- For each of the 2n-1 centers, expansion can take O(n) in the worst case.

Space Complexity: O(1)  
- No extra data structures used beyond variables.

Example:
Input  : "aaa"  
Output : 6  
Explanation: "a", "a", "a", "aa", "aa", "aaa"

Author: Teja Nayani  
Date  : September 13, 2025
*/

class PalindromicSubstrings {
    private int expandPalindrome(String s, int n, int left, int right){
        int count = 0;
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int result = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            result += expandPalindrome(s, n, i, i); //odd length center - n centers
            result += expandPalindrome(s, n, i, i+1); //even length center - n-1 centers
        }
        return result;
    }
}