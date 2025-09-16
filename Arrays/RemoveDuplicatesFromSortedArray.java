/*
Problem    : Remove Duplicates from Sorted Array
LeetCode   : https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Approach   : Two-Pointer Technique (Read and Write Pointers)
-------------------------------------------------------------
Goal       : Modify the given sorted array in-place such that each unique element appears only once,
             and return the new length. No extra space should be used.

- Use one pointer `write` to indicate the position of the next unique element.
- Iterate through the array from index 1 to end:
    • If the current element is different from the previous one,
      it means it's unique and should be written to the `write` pointer.
    • Assign it to `nums[write]` and increment `write`.
- At the end of the loop, all unique elements are at the start of the array up to index `write - 1`.

Time Complexity   : O(n)  
Space Complexity  : O(1) — in-place modification

Example:
Input  : nums = [1,1,2]
Output : 2, with nums modified to [1,2,_]

Author: Teja Nayani  
Date  : September 16, 2025
*/

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int write = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[write++] = nums[i];
            }
        }
        return write;
    }
}
