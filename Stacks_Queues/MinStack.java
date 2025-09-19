/* 
Problem     : Min Stack  
LeetCode    : https://leetcode.com/problems/min-stack/  
Approach    : Two Stacks – (Main Stack + Min Stack)  
-----------------------------------------------------
Goal        : Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

- Use two stacks:
    1. stack → stores all elements.
    2. minStack → stores the minimum element at each level.
- On `push(val)`:
    → Push `val` to stack.
    → If `minStack` is empty or val < top of minStack, push val to minStack.
    → Else, push top of minStack again (to preserve the current min).
- On `pop()`:
    → Pop from both stack and minStack.
- On `top()`:
    → Return top of stack.
- On `getMin()`:
    → Return top of minStack.

Time Complexity   : O(1) for all operations.  
Space Complexity  : O(n) — for maintaining two stacks.

Example:  
Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]  
       [[],        [-2],  [0],   [-3],     [],     [],   [],     []]  
Output: [null,      null, null,  null,     -3,     null, 0,     -2]

Author: Teja Nayani  
Date  : September 18, 2025  
*/

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    Deque<Integer> stack, minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val < minStack.peek()){ //push val into minStack if val is the new min (smallest)
            minStack.push(val);
        }else{
            minStack.push(minStack.peek()); //re-push current min which is minStack.peek()
        }        
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */