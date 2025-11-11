/*
Problem     : First Bad Version
LeetCode    : https://leetcode.com/problems/first-bad-version/

Goal:
Find the first bad version in a sequence of product versions using the least number of API calls.

Explanation:
----------------------------------------------------
1) Versions are labeled from 1 to n.
2) Use binary search to minimize API calls:
     - mid = left + (right - left)/2.
     - If isBadVersion(mid) is true → move right = mid (bad or before bad).
     - Else → move left = mid + 1 (safe, look ahead).
3) Loop ends when left == right — the first bad version.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Teja Nayani  
Date  : 30 October, 2025
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
