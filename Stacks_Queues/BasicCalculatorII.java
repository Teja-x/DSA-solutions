/*
Problem    : Basic Calculator II
LeetCode   : https://leetcode.com/problems/basic-calculator-ii/

Goal       : Evaluate a simple arithmetic expression string containing
             non-negative integers and operators (+, -, *, /).
             Handle operator precedence without using built-in eval().

Approach   : Stack-based Evaluation
------------------------------------------------------
- Traverse the string character by character.
- Build numbers when encountering digits.
- When an operator (or end of string) is found:
    • Apply the previous operator (`lastOp`) to the current number.
    • Push results onto the stack.
    • Reset the number and update `lastOp`.
- At the end, sum all values from the stack for the final result.

Why Stack?
- Stack helps to correctly handle multiplication/division immediately,
  while keeping addition/subtraction deferred until the final sum.

Time Complexity   : O(n)
    - Each character is processed once.
    - Stack operations are O(1).

Space Complexity  : O(n)
    - Worst case stack stores all numbers.

Example:
Input  : "3+2*2"
Output : 7

Input  : " 3/2 "
Output : 1

Author   : Teja Nayani
Date     : September 22, 2025
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorII {
    public boolean isOp(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch =='/';
    }

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char lastOp = '+';  // operator to apply to the number we've just built
        int num = 0, n = s.length();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(i < n-1 && ch == ' ')
                continue;

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            if(isOp(ch) || i == n-1){
                if(lastOp == '+'){
                    stack.push(num);
                }else if(lastOp == '-'){
                    stack.push(-num);
                }else if(lastOp == '*'){
                    stack.push(stack.pop() * num);
                }else{
                    stack.push(stack.pop() / num);
                }                
                num = 0;
                lastOp = ch;
            }
        }
        int value = 0;
        while(!stack.isEmpty()){
            value += stack.pop();
        }       
        return value;
    }
}
