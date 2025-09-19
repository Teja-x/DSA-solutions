/*
Problem     : Daily Temperatures  
LeetCode    : https://leetcode.com/problems/daily-temperatures/  
Approach    : Monotonic Decreasing Stack  
-----------------------------------------------------
Goal        : For each day, calculate how many days you'd have to wait until a warmer temperature.

Intuition   : 
- We want the *next greater element* on the right for each temperature.
- We'll use a **stack** to keep track of indices in decreasing order of temperatures.
- When we find a warmer temperature, we update the waiting time for the day at top of stack.

🧠 Method 1: Left to Right
- Traverse temperatures from left to right.
- Maintain a stack of indices whose temperatures haven’t found a warmer day yet.
- For each current temperature, while it is **greater than** the temperature at top of stack:
    → Pop index `j` from stack.
    → Set `wait[j] = i - j`
- Push the current index into stack.

🧠 Method 2: Right to Left (Alternative)
- Traverse from right to left.
- Pop all indices where current >= temperature (smaller elements), since they are useless.
- If stack not empty: it contains the index of the next warmer temperature.

Time Complexity   : O(n)  
Space Complexity  : O(n) — for the stack and output array.

Example:  
Input : temperatures = [73,74,75,71,69,72,76,73]  
Output: [1,1,4,2,1,1,0,0]

Author: Teja Nayani  
Date  : September 18, 2025  
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> decreasingStack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] wait = new int[n];
        for(int i = 0; i < n; i++){
            while(!decreasingStack.isEmpty() && temperatures[i] > temperatures[decreasingStack.peek()]){
                int j = decreasingStack.pop();
                wait[j] = i-j;
            }
            decreasingStack.push(i);
        }
        return wait;
        
        /*
        Deque<Integer> decreasingStack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] wait = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!decreasingStack.isEmpty() && temperatures[i] >= temperatures[decreasingStack.peek()]){
                decreasingStack.pop();
            }
            if(!decreasingStack.isEmpty()){
                wait[i] = decreasingStack.peek() - i;
            }
            decreasingStack.push(i);
        }
        return wait;
        */
    }
}
