/*
Problem     : Search in Rotated Sorted Array
LeetCode    : https://leetcode.com/problems/search-in-rotated-sorted-array/

Goal:
Find the index of a target element in a rotated sorted array using binary search.

Explanation:
----------------------------------------------------
1) The array is sorted but rotated at some pivot — one half remains sorted at any point.
2) Use binary search:
     - Compute mid = left + (right - left)/2.
     - If nums[mid] == target → return mid.
     - If left half (nums[left] ≤ nums[mid]) is sorted:
           → Check if target lies within this range [left, mid).
             - If yes → move right = mid - 1.
             - Else → move left = mid + 1.
     - Else (right half sorted):
           → Check if target lies within (mid, right].
             - If yes → move left = mid + 1.
             - Else → move right = mid - 1.
3) Continue until left > right → target not found.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Teja Nayani  
Date  : 28 October, 2025
*/

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
