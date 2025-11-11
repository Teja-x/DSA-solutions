/*
Problem     : Search Insert Position
LeetCode    : https://leetcode.com/problems/search-insert-position/

Goal:
Find the index of a target element in a sorted array, or determine the position where it should be inserted to maintain order.

Explanation:
----------------------------------------------------
1) Use binary search with pointers `left` and `right`.
2) While left <= right:
     - Compute mid = left + (right - left)/2.
     - If nums[mid] == target → return mid.
     - If target < nums[mid] → search left half → right = mid - 1.
     - Else → search right half → left = mid + 1.
3) If target not found, return `left` (insert position).

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Teja Nayani  
Date  : 28 October, 2025
*/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
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
        return left;
    }
}
