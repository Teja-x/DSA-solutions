/*
Problem: Find All Duplicates in an Array
Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/

Approach:
- Each value `nums[i]` is mapped to an index `abs(nums[i]) - 1`
- We negate the value at that index
- If it's already negative, it's a duplicate

Time Complexity: O(n)
Space Complexity: O(1) (excluding the output list)

Note:
- Mutates the input array (restoration can be done if required)
- Efficient use of in-place negative marking

Author: Teja Nayani
Date: June 9, 2025
*/
import java.util.ArrayList;
import java.util.List;

class FindDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        List<Integer> resultArray = new ArrayList<>();
        
        for(int i=0; i<length; i++){
            int temp = Math.abs(nums[i]) - 1;
            if(nums[temp]<0){
                resultArray.add(temp+1);
            }else{
                nums[temp]=-nums[temp];
            }
        }
        return resultArray;
    }
}

