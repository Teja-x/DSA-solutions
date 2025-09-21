/* 
Problem    : Asteroid Collision
LeetCode   : https://leetcode.com/problems/asteroid-collision/

Approach   : Stack Simulation (Deque)
------------------------------------------------------
Goal       : Simulate asteroid collisions where positive numbers move right 
             and negative numbers move left. Return the state after all collisions.

- Traverse each asteroid in the input:
    • If asteroid > 0 (right-moving), push directly onto stack.
    • If asteroid < 0 (left-moving), check stack top:
        - While top is positive and smaller/equal in size, pop (right (prev) asteroid explodes).
        - If equal size, pop and mark both as destroyed.
        - If stack is empty or top is also negative, push left (prev) asteroid (safe to survive).
- At the end, stack contains final asteroid states in order.

Time Complexity   : O(n)  
    - Each asteroid is pushed/popped at most once.

Space Complexity  : O(n)  
    - Stack stores surviving asteroids.

Example:
Input  : asteroids = [5, 10, -5]
Output : [5, 10]
Explanation: -5 collides with 10 and explodes, leaving [5, 10].

Author   : Teja Nayani
Date     : September 20, 2025
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        int asteroid, curr;
        boolean same;
        for(int i = 0; i < asteroids.length; i++){
            curr = asteroids[i];
            if(curr > 0){
                stack.push(curr);    // right-moving: always safe to push
            }else{
                // left-moving: fight with right-movers on stack
                asteroid = Math.abs(curr);
                same = false;
                while(!stack.isEmpty() && stack.peek() > 0 && asteroid >= stack.peek()){
                    if(stack.pop() == asteroid){     // equal size -> both explode
                        same = true;  
                        break;
                    }
                }
                if(same)             // left(curr) one also explodes; skip push
                    continue;                    
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(curr);
                }
            }
        }
        int[] state = new int[stack.size()];
        int idx = stack.size()-1;
        while(!stack.isEmpty()){
            state[idx--] = stack.pop();
        }
        return state;
    }
}
