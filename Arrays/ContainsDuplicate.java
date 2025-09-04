/*
Problem: Contains Duplicate
Link: https://leetcode.com/problems/contains-duplicate/

Approach:
- Use a HashSet to keep track of unique elements.
- Iterate through the array:
    - If the current element is already in the set, return true.
    - Else, add the element to the set.
- If no duplicates are found after the loop, return false.

Time Complexity: O(n)
- Each add/contains operation in HashSet is O(1) on average.
- Total time is proportional to the number of elements.

Space Complexity: O(n)
- In worst case, all elements are unique and added to the HashSet.

Note:
- HashSet internally uses HashMap to store elements as keys.
- `add()` returns false if the element already exists.

Author: Teja Nayani
Date: September 4, 2025
*/

import java.util.HashSet;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int ele : nums) {
            // If element already in set, it's a duplicate
            if (!hs.add(ele)) {
                return true;
            }
        }

        // No duplicates found
        return false;
    }
}
