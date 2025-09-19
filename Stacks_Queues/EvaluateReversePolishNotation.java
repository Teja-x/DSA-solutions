/*
Problem    : Evaluate Reverse Polish Notation  
LeetCode   : https://leetcode.com/problems/evaluate-reverse-polish-notation/

Approach   : Stack-Based Evaluation  
------------------------------------------------------
Goal       : Given tokens in RPN (postfix) form, evaluate and return the numeric result.

- Use a stack of integers.
- Iterate over the tokens:
    • If the token is an operator (`+`, `-`, `*`, `/`), pop two values (`val1`, `val2`) from stack:
         - Compute `val2 op val1` (note the order matters, `val2` was pushed earlier).
         - Push result back onto stack.
    • If token is a number (possibly negative / multi-digit), parse it and push onto stack.
- After processing all tokens, the stack’s top holds the final result.

Time Complexity   : O(n)  
    - n = number of tokens (each token processed once)

Space Complexity  : O(n)  
    - Stack size may grow proportional to number of tokens in worst case

Example:
Input  : ["2","1","+","3","*"]  
Output : 9  
Explanation: ((2 + 1) * 3) = 9

Author: Teja Nayani  
Date   : September 19, 2025
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int val, val1, val2;
        for(int i = 0; i < tokens.length; i++){
            char op = tokens[i].charAt(0);
            if(tokens[i].length() == 1 && (op == '+' || op == '-' || op == '*' || op == '/')){
                val1 = stack.pop();
                val2 = stack.pop();
                if(op == '+'){
                    stack.push(val2+val1);
                }else if(op == '-'){
                    stack.push(val2-val1);
                }else if(op == '*'){
                    stack.push(val2*val1);
                }else{
                    stack.push(val2/val1);
                }
            }else{
                val = Integer.parseInt(tokens[i]);
                stack.push(val);
            }
        }
        return stack.peek();
    }
}
