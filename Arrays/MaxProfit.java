/*
Problem: Best Time to Buy and Sell Stock 
Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Approach: Single Pass with Running Minimum
------------------------------------------
- Goal: Maximize the profit by choosing a single day to buy and a different day in the future to sell.
- Key Insight: For every price[i], the best profit is the difference between price[i] and the lowest price seen so far.
- Track:
    1. `lowestSoFar` – the minimum price encountered up to index i.
    2. `max` – the maximum profit seen so far by comparing prices[i] - lowestSoFar.
- Only one forward pass is needed to keep updating both.

Time Complexity: O(n)
    - Traverse the array once, updating min and profit on the go.

Space Complexity: O(1)
    - No extra space used apart from a couple of variables.

Accepted in Leetcode – runs in linear time, optimal and clean.

Edge Case:
- If prices are decreasing throughout → no profit → return 0.

Author: Teja Nayani
Date: September 9, 2025
*/

class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lowestSoFar = Integer.MAX_VALUE;
        for(int i =0; i < prices.length; i++){
            if(prices[i] < lowestSoFar){
                lowestSoFar = prices[i];
            }
            max = Math.max(max, prices[i]-lowestSoFar);
        }
        return max;
    }
}