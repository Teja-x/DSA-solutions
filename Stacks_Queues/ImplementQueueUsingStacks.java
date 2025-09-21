/* 
Problem    : Implement Queue using Stacks
LeetCode   : https://leetcode.com/problems/implement-queue-using-stacks/

Approach   : Two Stacks (Amortized O(1))
------------------------------------------------------
Goal       : Design a queue (FIFO) using stack(s) (LIFO).
             Implement push, pop, peek, and empty operations.

- Maintain two stacks: `inStack` and `outStack`.
- Push(x): Always push into `inStack`.
- Pop():
    • If `outStack` is empty, transfer all elements from `inStack` to `outStack`.
    • Then pop from `outStack`.
- Peek():
    • If `outStack` is empty, transfer elements from `inStack`.
    • Return top of `outStack`.
- Empty(): True only if both stacks are empty.

Time Complexity   :
    • Push → O(1)  
    • Pop, Peek → Amortized O(1) (each element moved at most once)  
    • Empty → O(1)

Space Complexity  : O(n)
    - Two stacks store all elements.

Example:
Input  : ["ImplementQueueUsingStacks","push","push","peek","pop","empty"]
         [[],[1],[2],[],[],[]]
Output : [null,null,null,1,1,false]

Author   : Teja Nayani
Date     : September 20, 2025
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public ImplementQueueUsingStacks() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                int ele = inStack.pop();
                outStack.push(ele);
            }
        }
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                int ele = inStack.pop();
                outStack.push(ele);
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */