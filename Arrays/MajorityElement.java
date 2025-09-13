/*
Problem: Majority Element  
LeetCode: https://leetcode.com/problems/majority-element/

Approach: Boyer-Moore Voting Algorithm
--------------------------------------------
- Goal: Find the element that appears more than ⌊n/2⌋ times in the array.

Strategy:
- The key idea is to cancel out each occurrence of an element with another one that is different.
- Keep a `count` and a `majorityCandidate`.
- If `count` is zero, choose the current element as the new candidate.
- If the current element equals the candidate, increment `count`, else decrement.
- By the end of iteration, the `majorityCandidate` will be the element that occurs > n/2 times.
- Assumption: A majority element is always guaranteed to exist.

Time Complexity: O(n)  
Space Complexity: O(1)

Example:
Input : [3,2,3]       → Output: 3  
Input : [2,2,1,1,1,2,2] → Output: 2

Author: Teja Nayani  
Date  : September 11, 2025
*/

class MajorityElement {
    public int majorityElement(int[] nums) {
        //Boyer-mooere voting algorithm
        int majorityCandidate = nums[0];
        int count = 0;
        for(int ele : nums){
            if(count == 0){
                majorityCandidate = ele;
            }
            count += ((majorityCandidate == ele) ? 1 : -1);
        }
        return majorityCandidate;
    }
}