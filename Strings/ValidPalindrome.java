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
        //StringBuilder sb = new StringBuilder(s);
      
        int p = 0, q = s.length() - 1;
        //boolean flag = false;
        
        while(p <= q){
            while(!Character.isLetterOrDigit(s.charAt(p)) && p<q){
                p++;
            }
            while(!Character.isLetterOrDigit(s.charAt(q)) && p<q){
                q--;
            }

            /*if((Character.toLowerCase(s.charAt(p)) == Character.toLowerCase(s.charAt(q)))){
                p++;
                q--;
                flag = true;
            }else{
                flag = false;
                return flag;
            }*/

            if((Character.toLowerCase(s.charAt(p)) != Character.toLowerCase(s.charAt(q)))){
                return false;
            }
            p++;
            q--;
        }

        return true;
    }
}