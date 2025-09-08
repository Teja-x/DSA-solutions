/*
Problem: 3Sum
Leetcode: https://leetcode.com/problems/3sum/

Approach: Sorting + Two Pointers
---------------------------------
- Goal: Find all unique triplets in the array such that their sum is zero.
- Step 1: Sort the array.
- Step 2: Fix one element `nums[i]` and use two pointers (`start`, `end`) to find pairs such that:
          nums[i] + nums[start] + nums[end] == 0
- Step 3: Skip duplicate values for both `i`, `start`, and `end` to avoid duplicate triplets.
- Step 4: Move pointers based on current sum:
    - If sum < 0 → move `start++`
    - If sum > 0 → move `end--`
    - If sum == 0 → store triplet and continue adjusting both pointers.

Time Complexity: O(n²)
    - Outer loop runs n times
    - Inner two-pointer scan runs in O(n) → Total O(n²)

Space Complexity: O(1) extra (excluding output list)
    - No additional data structures used other than result list

Accepted in Leetcode — handles duplicates efficiently and is an optimal solution.

--------------------------------------------------------------

Alternate Approach: HashMap-based Brute Force (Not Preferred)
--------------------------------------------------------------
- Use 2 loops and a hashmap to find the third element.
- Time: O(n²), but managing duplicates becomes messy.
- Space: O(n) for hashmap

Drawback:
- More prone to duplicate triplets and not optimal in interviews.

--------------------------------------------------------------

Notes:
- Key to this problem is:
    - Sorting
    - Skipping duplicates
    - Carefully managing two-pointer traversal

Author: Teja Nayani
Date: September 8, 2025
*/
cl

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && (nums[i] == nums[i-1]))
                continue;

            int start = i+1, end = nums.length-1;
            while(start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));                   
                    start++;
                    end--;

                    while(start<end && (nums[start] == nums[start-1])){
                        start++;
                    }
                    while(start<end && nums[end] == nums[end+1]){
                        end--;
                    }
                }else if(sum > 0){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return result;
    }
}