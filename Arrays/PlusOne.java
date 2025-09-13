/*
Problem: Plus One  
LeetCode: https://leetcode.com/problems/plus-one/

Approach: Reverse Iteration from Last Digit
--------------------------------------------
- Goal: Given an integer represented as an array of digits, add one to the number and return the resulting array.

Strategy:
- Start from the end of the array (least significant digit).
- If the digit is 9, set it to 0 (since 9 + 1 = 10 → carry over).
- If the digit is not 9, increment it and return the array (no carry forward needed).
- If all digits were 9 (e.g., [9,9,9]), after the loop the array becomes [0,0,0], and we need a new array with an extra leading 1 → [1,0,0,0].

Time Complexity: O(n)
- n = length of the input array (as we might need to process all digits)

Space Complexity: O(n)
- A new array is created only in the worst case (e.g., all 9s), otherwise modified in-place.

Example:
Input : [1,2,3] → Output: [1,2,4]  
Input : [9,9,9] → Output: [1,0,0,0]

Author: Teja Nayani  
Date  : September 11, 2025
*/

class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i] += 1;
                return digits;
            }
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
}