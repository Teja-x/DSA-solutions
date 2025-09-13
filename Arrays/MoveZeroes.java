/*
Problem: Move Zeroes
LeetCode: https://leetcode.com/problems/move-zeroes/

Approach: In-Place Zero Shift using Zero Counter
----------------------------------------------------
- Goal: Shift all zeroes in the array to the end, maintaining the relative order of non-zero elements.
- Constraint: Must be done in-place without using extra space.

Strategy:
- Use a `zeroes` counter to track how many zeroes have been encountered so far.
- As we iterate:
    - If the current number is non-zero and we've already seen at least one zero,
      we shift the current number `zeroes` positions to the left.
- Once all non-zero elements are shifted, fill the remaining `zeroes` positions at the end with 0s.

Advantages:
- Optimized single-pass solution (O(n)) with in-place shifting and no need for extra memory.
- Handles edge cases like no zeroes, all zeroes, or zeros at beginning/end gracefully.

Time Complexity: O(n)
- One pass to shift non-zeroes forward, one pass to fill trailing zeroes.

Space Complexity: O(1)
- In-place solution with no additional data structures.

Author: Teja Nayani  
Date  : September 10, 2025
*/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroes = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0){
                zeroes++;
            }
            if(nums[i]!=0 && zeroes>0){
                nums[i-zeroes] = nums[i];
                //nums[i] = 0;
            }
        }
        if(zeroes==0)
            return;

        for(int i = nums.length-zeroes; i < nums.length; i++){
            nums[i] = 0;
        }
        return;
    }
}