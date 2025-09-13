/*
Problem: Best Time to Buy and Sell Stock II  
LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Approach: Greedy  
--------------------------------------------
- The goal is to maximize profit by making as many transactions as you like.
- You can buy and sell on the same day, but must sell before buying again.
- Greedy strategy: Add all upward price differences (i.e., whenever prices[i] > prices[i-1]).
- For ex: [a,c] = [a,b] + [b,c] i.e c-a = (b-a) + (c-b)
- This captures all increasing slopes to simulate multiple buys and sells.

Logic:
- Loop through the array starting from index 1.
- If today's price is higher than yesterday's, add the profit.
- This simulates buying yesterday and selling today.

Time Complexity: O(n)  
Space Complexity: O(1)

Example:
Input  : prices = [7,1,5,3,6,4]  
Output : 7  
Explanation: Buy on day 2 (price=1), sell on day 3 (price=5) → profit = 4  
             Buy on day 4 (price=3), sell on day 5 (price=6) → profit = 3  
             Total profit = 7

Author: Teja Nayani  
Date  : September 12, 2025
*/

class MaxProfitII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
