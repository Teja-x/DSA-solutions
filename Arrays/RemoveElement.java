/*
Problem: Remove Element  
LeetCode: https://leetcode.com/problems/remove-element/

Approach: Two-Pointer / In-place Overwrite
--------------------------------------------
- Goal: Remove all instances of a given value `val` from the array `nums` in-place and return the new length.
- The order of elements can be changed. It doesn't matter what values are left beyond the returned length.

Strategy:
- Use a `write` pointer to track the position to overwrite.
- Iterate through the array:
    - If the current element is NOT equal to `val`, assign it to `nums[write++]` (while incrementing `write`).
    - If it's equal to `val`, skip it.
- The first `write` elements of the array will now be free of `val`.

Time Complexity: O(n)  
Space Complexity: O(1)

Example:
Input  : nums = [3,2,2,3], val = 3  
Output : 2  
Array becomes: [2,2,_,_]

Author: Teja Nayani  
Date  : September 12, 2025
*/

class RemoveElement {
    public int removeElement(int[] nums, int val) {
       int write = 0;
       for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[write++] = nums[i];
            }
       }
       return write;
    }
}
