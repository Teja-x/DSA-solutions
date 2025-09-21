/* 
Problem    : Implement Stack using Queues
LeetCode   : https://leetcode.com/problems/implement-stack-using-queues/

Goal       : Design a stack (LIFO) using only queue operations (FIFO).

Approach 1 : Single Queue (Costly Push)
-------------------------------------------------------
- Use one queue.
- On push(x): 
    • Add x to queue.  
    • Rotate previous elements behind x → making x always at the front.  
- Pop() / Top() → directly from queue front.
- Complexity:
    • Push → O(n) (rotation needed)  
    • Pop / Top → O(1)  
    • Space → O(n)

Approach 2 : Two Queues (Costly push - cheap pop/peek)
-------------------------------------------------------
- Use q1 and q2.
- Push(x):  
    • Enqueue into q2.  
    • Transfer all elements from q1 → q2.  
    • Swap q1 and q2.  
- Pop/Top → directly from q1.
- Complexity:
    • Push → O(n)  
    • Pop / Top → O(1)  
    • Space → O(n)

Example:
Input  : ["ImplementStackUsingQueues","push","push","top","pop","empty"]
         [[],[1],[2],[],[],[]]
Output : [null,null,null,2,2,false]

Author   : Teja Nayani
Date     : September 21, 2025
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackUsingQueues {
    Deque<Integer> queue;        // single queue variant

    public ImplementStackUsingQueues() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) { 
        queue.offer(x);
        int n = queue.size();
        while(n-- > 1){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 /*
 class MyStack {
    Deque<Integer> q1;
    Deque<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) { 
        q2.offer(x);                // costly push O(n)
        while(!q1.isEmpty()){       // maintain the stack top at the front of a queue.
            q2.offer(q1.poll());
        }
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }        
    }
    
    public int pop() {
        return q1.poll();           // O(1) - cheap pop
    }
    
    public int top() {
        return q1.peek();           // O(1) - cheap peek
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
*/