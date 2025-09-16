/*
Problem    : Trapping Rain Water
LeetCode   : https://leetcode.com/problems/trapping-rain-water/

Approach   : Two Pointers with Left/Right Max Tracking
-------------------------------------------------------
- Initialize two pointers: `left` at 0, `right` at n-1.
- Keep track of `lMax` (max height to the left) and `rMax` (max height to the right).
- While `left < right`:
    • If height[left] < height[right], process the left pointer:
        ◦ Update lMax if needed
        ◦ Add trapped water = lMax - height[left]
        ◦ Move left++
    • Else, process the right pointer:
        ◦ Update rMax if needed
        ◦ Add trapped water = rMax - height[right]
        ◦ Move right--
- The water trapped at each index is determined by the shorter max boundary(height) minus the current height.

Time Complexity   : O(n)  
Space Complexity  : O(1)

Example:
Input  : [0,1,0,2,1,0,1,3,2,1,2,1]
Output : 6

Author: Teja Nayani  
Date  : September 15, 2025
*/

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1, lMax = height[0], rMax = height[n-1], water = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > lMax)
                    lMax = height[left];
                water += (lMax - height[left]);
                left++;                                
            }else{
                if(height[right] > rMax)
                    rMax = height[right];
                water += (rMax - height[right]);
                right--;
            }
        }
        return water;
    }
}
