/*
Problem     : Binary Search
LeetCode    : https://leetcode.com/problems/binary-search/

Goal:
Given a sorted integer array and a target, return the index of the target if found, else -1.

Explanation:
----------------------------------------------------
1) Initialize two pointers: left = 0, right = n - 1.
2) While left <= right:
     - Compute mid = left + (right - left)/2 to avoid overflow.
     - If nums[mid] == target → return mid.
     - If target < nums[mid] → shrink right = mid - 1.
     - Else → shift left = mid + 1.
3) Return -1 if target not found.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Teja Nayani  
Date  : 27 October, 2025
*/

class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}