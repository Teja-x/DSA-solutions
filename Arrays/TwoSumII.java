/*
Problem: Two Sum II – Input Array Is Sorted
Leetcode: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Approach: Two Pointer Technique
-------------------------------
- Given a sorted array, find two numbers such that they add up to a specific target.
- Use two pointers:
    - One starting at the beginning (`start`)
    - One at the end (`end`)
- Move pointers inward:
    - If the sum is less than the target → move `start` forward.
    - If the sum is greater than the target → move `end` backward.
    - If sum equals the target → return 1-based indices.

Time Complexity: O(n)
    - Each pointer moves at most once per iteration → linear scan.

Space Complexity: O(1)
    - No extra data structures used.

Accepted in Leetcode — very efficient and optimal for sorted input.

--------------------------------------------------------------

Notes:
- Be careful to return 1-based indices as per problem statement (not 0-based).
- Don’t confuse this with the normal Two Sum problem (unsorted input).

*/

class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length-1;
        while(start < end){
            int sum = numbers[start]+numbers[end];
            if(sum == target){
                return new int[]{start+1, end+1};
            }else if(sum < target){
                start++;
            }
            else{
                end--;
            }
        }
        return null;
    }
}
