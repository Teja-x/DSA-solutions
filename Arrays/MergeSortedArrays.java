/*
Problem: Merge Sorted Array  
LeetCode: https://leetcode.com/problems/merge-sorted-array/

Approach: In-Place Merge from End (No Extra Space)
-----------------------------------------------------
- Goal: Merge two sorted arrays nums1 and nums2 into nums1 in-place, maintaining sorted order.
- Constraint: nums1 has enough space to hold elements from nums2 (size = m + n)

Strategy:
- Start comparing from the **end** of both arrays (`p1 = m-1`, `p2 = n-1`).
- Use a `write` pointer from the end (`m + n - 1`) to fill in the largest elements.
- Whichever value is larger between `nums1[p1]` and `nums2[p2]`, place it at `nums1[write]`.
- This avoids overwriting unprocessed values in nums1 and doesn’t require extra memory.

Time Complexity: O(m + n)
- Each element is touched only once.

Space Complexity: O(1)
- No additional memory used.

Alternate (Commented) Approach:
- Uses O(m + n) extra space for clarity and easier implementation, but not optimal.

Author: Teja Nayani  
Date  : September 10, 2025
*/

class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // using O(1) space - in-place approach without using extra space
        int p1=m-1, p2=n-1;
        int write = m+n-1;
        //Compare two arrays from Last and place the largest element towards the end of nums1. Continue the same for next largest element. This way you don't need extra space as the current operation doesn't overwrite the last processed value 
        while(p1>=0 && p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[write--] = nums1[p1--];
            }else{
                nums1[write--] = nums2[p2--];
            }
        }
        while(p1>=0){
            nums1[write--] = nums1[p1--];
        }
        while(p2>=0){
            nums1[write--] = nums2[p2--];
        }

        /* using extra space O(m+n)
        int[] result = new int[m+n];
        int p1=0, p2=0, idx=0;
        while(p1<m && p2<n){
            if(nums1[p1] < nums2[p2]){
                result[idx++] = nums1[p1++];
            }else{
                result[idx++] = nums2[p2++];
            }
        }
        while(p1<m){
            result[idx++] = nums1[p1++];
        }
        while(p2<n){
            result[idx++] = nums2[p2++];
        }
        for(int i  = 0; i < m+n ; i++){
            nums1[i] = result[i];
        }
        return;
        */
    }
}