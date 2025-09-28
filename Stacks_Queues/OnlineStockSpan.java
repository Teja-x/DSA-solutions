/*
Problem    : Online Stock Span
LeetCode   : https://leetcode.com/problems/online-stock-span/

Goal       : Design an algorithm that computes the stock span for each day's price.
             The stock span of today's price is the number of consecutive days (including today)
             the price has been less than or equal to today's price.

Approach   : Monotonic Decreasing Stack
------------------------------------------------------------
- Use a stack of pairs [price, span].
- For each incoming `price`:
    • Start span = 1 (at least today).
    • While stack top price <= current price:
        - Pop stack and add its span to the current span.
    • Push [price, span] onto stack.
- Return span for this query.

Why it Works?
- Monotonic stack compresses consecutive smaller/equal prices into a single span count.
- Ensures each price is pushed and popped at most once → amortized O(1).

Time Complexity   : O(1) Amortized
    - Each element is processed once across all queries.
Space Complexity  : O(n)
    - Stack stores price-span pairs for active days.

Example:
Input  : ["StockSpanner","next","next","next","next","next","next","next"]
         [[],[100],[80],[60],[70],[60],[75],[85]]
Output : [null,1,1,1,2,1,4,6]

Author   : Teja Nayani
Date     : September 24, 2025
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && price >= stack.peek()[0]){
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */