/*
Problem: Longest Consecutive Sequence
Leetcode: https://leetcode.com/problems/longest-consecutive-sequence/

Approach 1: HashSet + Check Only Starting Points For Longest Consecutive Sequence (Optimal - O(n) Amortized Time)
-------------------------------------------------------------------------------- 
- Goal: Find the length of the longest sequence of consecutive integers.
- Use a HashSet to store all elements for O(1) lookup.
- For each number, only begin counting if it's the **start** of a sequence (i.e., num - 1 not in set).
- From that point, increment and count how many consecutive numbers exist.
- Update maximumum count accordingly.
Time Complexity: O(n)
    - Each number is visited at most once.
    - HashSet lookup and insert are O(1) on average.

Space Complexity: O(n)
    - For storing numbers in the HashSet.

This is the most optimal approach.

---------------------------------------------------------------

Approach 2: HashSet + Removing/Shrinking from Both Sides
---------------------------------------------------------------
- Goal: Find the length of the longest consecutive elements sequence in the array.
- Use a HashSet to store all elements (for O(1) lookup and deletion).
- For each element:
    - If it's still in the set:
        - Expand leftwards (`ele-1`) and rightwards (`ele+1`) while elements exist in the set.
        - Remove visited elements from the set to avoid reprocessing.
        - Track max streak length by expanding fully around each starting point.

Time Complexity: O(n) Amortized
    - Each element is inserted and removed from the set once → O(n) total.

Space Complexity: O(n)
    - HashSet stores all elements for fast lookup.

This is the an optimal approach.
---------------------------------------------------------------

Notes:
- Uses O(n) Amortized complexity.
- Be cautious not to re-check elements already part of previous sequences.
- HashSet helps track seen elements and ensures no double-counting.

Author: Teja Nayani
Date: September 8, 2025
*/

import java.util.HashSet;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int ele : nums){
            hs.add(ele);
        }
        int max = 0;

        // Approach - Removing/Shrinking from Both Sides - Amortized complexity - O(n)
        for(int ele : nums){
            if(hs.contains(ele)){
                int left = ele - 1;
                int right = ele + 1;
                int length = 0;
                while(hs.remove(left)){
                    length++;
                    left--;                    
                }
                while(hs.remove(right)){                    
                    length++;
                    right++;
                }
                max = Math.max(max, length+1);
            }
        }

        // Approach - Check Only Starting Points For Longest Consecutive Sequence - Amortized complexity - O(n)
        /*for(int ele : hs){
            if(!hs.contains(ele-1)){
                int curr = ele;
                while(hs.contains(curr)){
                    curr++;
                }
                max = Math.max(max, curr-ele);
            }
        }*/

        return max;        
    }
}