/*
Problem    : Backspace String Compare
LeetCode   : https://leetcode.com/problems/backspace-string-compare/

Approach   : Two Pointers (Right to Left) with Skip Counters
-------------------------------------------------------------
Goal       : Determine whether two strings are equal after processing backspaces ('#'),
             without using extra space.

- Use two pointers `p1` and `p2` to iterate from the end of both strings `s` and `t`.
- Maintain skip counters `skip1` and `skip2` to track how many characters should be skipped due to `#`.
- For each string:
    • If a `#` is encountered, increment skip counter.
    • If skip counter > 0, skip current character and decrement counter.
    • Else, this character is valid for comparison.
- After determining valid characters at both pointers:
    • Compare characters, if mismatch → return false.
    • If only one pointer is valid (other is out of bounds) → return false.
- Move both pointers backward and repeat.
- If loop completes with no mismatch → return true.

Time Complexity   : O(n + m)  
Space Complexity  : O(1) — no extra space used

Example:
Input  : s = "ab#c", t = "ad#c"
Output : true

Author: Teja Nayani  
Date  : September 15, 2025
*/

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length()-1, p2 = t.length()-1;
        int skip1 = 0, skip2 = 0;
        while(p1 >= 0 || p2 >= 0){            
            while(p1 >= 0){
                if(s.charAt(p1) == '#'){
                    skip1++; //means we arrived at backspace, i.e have to skip/remove the next char
                    p1--;
                }
                else if(skip1 > 0){
                    skip1--; //need to remove this char because of previous '#'(s). We also need to decrement skip1 indicating that char is removed
                    p1--;
                }
                else
                    break; //means s.charAt(p1) is valid
            }
            while(p2 >= 0){
                if(t.charAt(p2) == '#'){
                    skip2++; //means we arrived at backspace, i.e have to skip/remove the next char
                    p2--;
                }else if(skip2 > 0){
                    skip2--; //need to remove this char because of previous '#'(s). We also need to decrement skip2 indicating that char is removed
                    p2--;
                }else
                    break; //means t.charAt(p2) is valid
            }

            if(p1 >= 0 && p2 >= 0){
                if(s.charAt(p1) != t.charAt(p2)){
                    return false;
                }
            }else{
                if(p1 >= 0 || p2 >= 0){ //one pointer has reached < 0 while other pointer still has char to process : hence false
                    return false;
                }
            }
            p1--;
            p2--;
        }
        return true;
    }
}
