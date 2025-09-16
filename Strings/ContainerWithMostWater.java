/*
Problem    : Container With Most Water
LeetCode   : https://leetcode.com/problems/container-with-most-water/

Approach   : Two Pointers (Greedy)
----------------------------------------------------
- Place two pointers: one at the start (`left`) and one at the end (`right`) of the array.
- At each step, calculate the area formed between `left` and `right` lines:
    • Height = min(height[left], height[right])
    • Breadth = right - left
- Update `maxAmount` if the calculated area is larger.
- Move the pointer pointing to the shorter line inward since the height is the limiting factor.

Time Complexity   : O(n)  
Space Complexity  : O(1)

Example:
Input  : [1,8,6,2,5,4,8,3,7]
Output : 49 (between 8 and 7 at indices 1 and 8)

Author: Teja Nayani  
Date  : September 15, 2025
*/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int left = 0, right = height.length-1;
        int maxAmount = 0;
        while(left < right){
            int ht = Math.min(height[left], height[right]), breadth = right-left;
            maxAmount = Math.max(maxAmount, ht*breadth);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxAmount;
    }
}
