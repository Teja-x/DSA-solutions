/*
Problem     : Find Minimum in Rotated Sorted Array
LeetCode    : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Goal:
Find the smallest element in a rotated sorted array (distinct integers).

Explanation:
----------------------------------------------------
1) Use binary search on the rotated array.
2) At each step:
     - Compute mid = left + (right - left)/2.
     - If nums[mid] > nums[right] → smallest lies in right half → left = mid + 1.
     - Else → smallest lies in left half (including mid) → right = mid.
3) Loop ends when left == right — pointing to the minimum element.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Teja Nayani  
Date  : 29 October, 2025
*/

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){ //smaller half is to the right
                left = mid + 1;
            }else{
                right = mid; //smaller half is to the left
            }
        }
        return nums[left];
    }
}
