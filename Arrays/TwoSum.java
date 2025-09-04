/*
Problem: Two Sum
Link: https://leetcode.com/problems/two-sum/

Approach:
- Use a HashMap to store previously seen values and their indices.
- For each element in the array, check if the complement (target - nums[i]) exists in the map.
- If found, return the indices of the current element and the complement.
- If not, store the current number and its index in the map.

Time Complexity: O(n)
- Each element is visited once; HashMap lookup and insertion are O(1).

Space Complexity: O(n)
- In worst case, we may store all elements in the HashMap.

Author: Teja Nayani
Date: Sept 4, 2025
*/

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            if(map.containsKey(target - nums[i])) {
                return new int[]{ map.get(target - nums[i]), i };
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{ -1, -1 };  // Return dummy if no solution found
    }
}