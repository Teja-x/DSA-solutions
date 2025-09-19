/* 
Problem     : Valid Parentheses  
LeetCode    : https://leetcode.com/problems/valid-parentheses/  
Approach    : Stack Based Matching  
-----------------------------------------------------
Goal        : Check if every opening bracket has a valid corresponding closing bracket in the correct order.

- If the string has odd length, it’s invalid.
- Use a stack to store opening brackets — '(', '[', '{'.
- For each character:
    → If it’s an opening bracket, push to stack.
    → If it’s a closing bracket:
        ↳ If the stack is empty, return false (no matching opener).
        ↳ Pop from stack and check if it matches the type.
- After traversal, stack should be empty for valid input.

Time Complexity   : O(n) — each character is processed once.
Space Complexity  : O(n) — in the worst case, all characters are opening brackets.

Example: 
Input  : s = "({[]})"  
Output : true

Author: Teja Nayani  
Date  : September 18, 2025  
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        if((s.length()%2) != 0)
            return false;
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if((ch == ']' && top != '[') || (ch == '}' && top != '{') || (ch == ')' && top != '('))
                    return false;
            }        
        }
        return stack.isEmpty();
    }
}
