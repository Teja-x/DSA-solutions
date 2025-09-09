/*
Problem: 4Sum (Leetcode #18)
Leetcode: https://leetcode.com/problems/4sum/
 
Approach: Two Pointers + Sorting + Pruning Optimization
---------------------------------------------------------

Intuition:
Find all unique quadruplets [a, b, c, d] such that a + b + c + d == target.
Same as 3Sum problem, but requires an extra loop - say 'j'
First, sort the array to use two-pointer strategy efficiently and allow pruning of unnecessary cases.

Logic:
1. Sort the array to handle duplicates and apply two-pointer technique.
2. Fix the first element `i` and loop through:
 - Skip duplicates at i
 - Apply pruning using maxSum and minSum to break/continue early
3. For each i, fix a second pointer `j` (apply pruning) and apply two-pointer (start, end) to find valid pairs.
 - Skip duplicates at j, start, and end
 - Check if current quadruplet sum equals target (casted to long to avoid overflow)
4. If valid, add to result list and adjust pointers while skipping duplicates

Edge Cases Handled:
 - Integer overflow handled by casting to long
 - Duplicate quadruplets avoided using sorted array and skip conditions
 
Time Complexity:
O(n^3) — three nested loops (`i`, `j`, and two pointers), optimized with pruning

Space Complexity:
O(1) extra space (excluding output list)

Author: Teja Nayani
Date: September 9, 2025
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length-3; i++){
            long maxSum = (long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(maxSum > target){
                break; //break from the loop - because the lowest 4 numbers sum is greater than target, all other right side numbers sum will also be greater than target as the array is sorted (increasing)
            }

            long minSum = (long)nums[i]+nums[n-1]+nums[n-2]+nums[n-3];
            if(minSum < target){
                continue; //continue to next iteration - because the max sum possible with nums[i] is still less than target, all the intermediate j, start, end will also be less than target
            }
        
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j < nums.length-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int start = j+1, end = nums.length-1;
                while(start < end){
                    long sum = (long)nums[i]+nums[j]+nums[start]+nums[end]; // type casting to long to avoid Integer overflow during operation
                    long T = target; //to avoid multiple type casts each time with sum(long) == target(int)
                    if(sum == T){
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                        while(start < end && nums[start] == nums[start-1]){
                            start++;
                        }
                        while(start < end && nums[end] == nums[end+1]){
                            end--;
                        }
                    }else if(sum < target){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return result;
    }
}