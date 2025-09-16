/*
Problem    : Subarray Sum Equals K
LeetCode   : https://leetcode.com/problems/subarray-sum-equals-k/

Approach   : Prefix Sum + HashMap
-----------------------------------------------------
Goal       : Count the number of subarrays that sum exactly to `k`.

- Maintain a `prefixSum` while iterating through the array.
- Use a HashMap to store the frequency of prefix sums seen so far.
- For each new `prefixSum`, check if `(prefixSum - k)` exists in the map:
    • If it does, it means there's a subarray ending at current index which sums to `k`.
- Add/update the current `prefixSum` in the map for future use.

Time Complexity   : O(n) — One pass through the array.
Space Complexity  : O(n) — HashMap stores up to n unique prefix sums.

Example:
Input  : nums = [1,2,3], k = 3
Output : 2 → Subarrays: [1,2], [3]

Author: Teja Nayani  
Date  : September 16, 2025
*/

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int prefSum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            prefSum += nums[i]; //running prefix sum.
            count += map.getOrDefault(prefSum-k, 0); //how many earlier prefixes make a subarray sum = k.
            map.put(prefSum, map.getOrDefault(prefSum, 0)+1); //record current prefix for future subarrays.
        }
        return count;
    }
}
