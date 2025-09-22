/*
Problem    : Remove K Digits
LeetCode   : https://leetcode.com/problems/remove-k-digits/

Goal       : Given a non-negative integer num (as a string) and an integer k, 
             remove k digits from num such that the resulting number 
             is the smallest possible.

Approach   : Monotonic Stack (Greedy)
------------------------------------------------------
- Traverse digits one by one.
- Maintain a monotonic increasing stack:
    • If the current digit < stack’s top and k > 0 → pop the stack (remove bigger digit).
    • Push the current digit into the stack.
- After traversal, if k > 0, remove from the end (pop extra digits).
- Rebuild result from stack while skipping leading zeros.
- If the result is empty, return "0".

Why it Works?
- Greedy removal ensures higher digits to the left are eliminated first,
  leaving the smallest lexicographical result.
- Using a stack guarantees order preservation while handling deletions efficiently.

Time Complexity   : O(n)  
    - Each digit is pushed and popped at most once.  
Space Complexity  : O(n)  
    - Stack to hold digits, and StringBuilder to construct result.

Example:
Input  : num = "1432219", k = 3
Output : "1219"

Input  : num = "10200", k = 1
Output : "200"

Author   : Teja Nayani
Date     : September 22, 2025
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int digit;
        for(char ch : num.toCharArray()){
            digit = ch - '0';                        
            while(!stack.isEmpty() && digit < stack.peek() && k > 0){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        StringBuilder smallest = new StringBuilder();

        while(!stack.isEmpty()){
            if(smallest.length() == 0 && stack.peekLast() == 0){ //checking digit from rear as stack in deque pushes element at the front.
                stack.pollLast();
                continue;
            }
            smallest.append(stack.pollLast());
        }
        
        if(smallest.length() == 0)
            return "0";

        return smallest.toString();
    }
}
