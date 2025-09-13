/*
Problem: Valid Palindrome (LeetCode 125)
Link: https://leetcode.com/problems/valid-palindrome/

Approach:
- Use two pointers: one from the beginning, one from the end.
- Skip non-alphanumeric characters using Character.isLetterOrDigit().
- Compare the characters in a case-insensitive way using Character.toLowerCase().
- Return false on mismatch, true if all match.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Teja Nayani
Date: June 9, 2025
*/

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int p1 = 0, p2 = s.length()-1;
        while(p1<p2){
            while(p1<p2 && !Character.isLetterOrDigit(s.charAt(p1))){
                p1++;
            }
            while(p1<p2 && !Character.isLetterOrDigit(s.charAt(p2))){
                p2--;
            }
            char c1 = Character.toLowerCase(s.charAt(p1));
            char c2 = Character.toLowerCase(s.charAt(p2));
            if(c1 != c2){
                return false;
            }
            p1++;
            p2--;
        }       
        return true;
    }
}