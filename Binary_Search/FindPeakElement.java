/*
Problem     : Find Peak Element
LeetCode    : https://leetcode.com/problems/find-peak-element/

Goal:
Find a “peak” element in an array — an element strictly greater than its neighbors.

Explanation:
----------------------------------------------------
1) Apply a modified binary search:
     - Compute mid = left + (right - left)/2.
     - If nums[mid] < nums[mid + 1]:
           → we are on an increasing slope — move right (left = mid + 1).
     - Else:
           → we are on a decreasing slope — move left (right = mid).
2) Loop ends when left == right, which points to a peak element.

Note:
- There can be multiple peaks; any one is valid.
- Works without needing to compare out-of-bound indices due to the direction-based logic.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Teja Nayani  
Date  : 30 October, 2025
*/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid+1]){ //we're on uphill - i.e peak may be mid+1 or to the right
                left = mid + 1; 
            }else{
                right = mid;             //we're on downhill - i.e peak maybe mid or to the left
            }
        }
        return left;
    }
}
