/*
Problem     : H-Index II  
LeetCode    : https://leetcode.com/problems/h-index-ii/

Goal:
Given a sorted array of citations (ascending order), find the researcher's h-index.
The h-index is defined as the maximum h such that the researcher has at least h papers
with ≥ h citations each.

Explanation:
----------------------------------------------------
1) Observations:
   - citations is sorted in ascending order.
   - For an index mid, the number of papers with ≥ citations[mid] is (n - mid).

2) Binary Search Logic:
   - Initialize left = 0, right = n - 1.
   - Compute mid = left + (right - left) / 2.
   - Let h = n - mid (potential h-index).
   - If citations[mid] ≥ h → valid candidate; try smaller mid to find larger h.
   - Else → not enough citations, move right (left = mid + 1).
   - After loop, left is the smallest index where citations[i] ≥ (n - i).

3) Return:
   - h = n - left (maximum valid h-index).

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Teja Nayani  
Date  : 9 November, 2025
*/

public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int h = n - mid;  // candidate h-index
            if(citations[mid] >= h){ // this mid works as a valid h-index candidate. But there might be a larger h (which needs a smaller mid),
                right = mid - 1; 
            }else{                   // invalid -> need smaller h
                left = mid + 1;
            }
        }
        // after the loop: 'left' is the smallest index i such that citations[i] >= (n - i),        
        return n-left;  // so the maximum h-index is h = n - left.
    }
}
