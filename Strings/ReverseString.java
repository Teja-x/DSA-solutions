/*
Problem: Reverse String (LeetCode 344)
Link: https://leetcode.com/problems/reverse-string/

Approach:
- Use two pointers: one at the start and one at the end.
- Swap characters and move pointers inward until they meet.
- Performs the reversal in-place.

Time Complexity: O(n)
Space Complexity: O(1)

Author: Teja Nayani
Date: June 9, 2025
*/

class ReverseString {
    public void reverseString(char[] s) {
        int p=0, q=s.length-1;
        while(p<q){
            char temp = s[p];
            s[p]=s[q];
            s[q]=temp;
            p++;
            q--;
        }
    }
}