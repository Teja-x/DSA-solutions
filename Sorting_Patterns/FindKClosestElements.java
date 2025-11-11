/*
Problem     : Find K Closest Elements
LeetCode    : https://leetcode.com/problems/find-k-closest-elements/

Goal:
Given a sorted array, a number k, and a target x,
return the k closest elements to x (in sorted order).
If there's a tie, prefer the smaller elements.

Approach : Binary Search on Window Start
----------------------------------------------------
1) Observation:
   - The k closest elements will form a contiguous subarray of length k.
   - So we only need to find the best starting index for this window.

2) Define search space:
   - left = 0
   - right = n - k
   - Each mid represents a candidate window: [mid .. mid + k - 1]

3) Compare two adjacent windows:
   - Window A: [mid .. mid + k - 1]
   - Window B: [mid + 1 .. mid + k]
   - Compare distance of edges to x:
        if (x - arr[mid]) > (arr[mid + k] - x)
            → Window B is closer → move right: left = mid + 1
        else
            → Window A is closer (or equal with smaller values) → move left: right = mid

4) When left == right:
   - This is the optimal window start.
   - Return elements from arr[left] to arr[left + k - 1].

Why It Works:
- Distances behave monotonically with respect to the window position,
  which makes binary search valid on the window start index.

Time Complexity : O(log(n - k) + k)
   - Binary search on window start + collecting k elements
Space Complexity: O(1) extra (excluding output list)

--------------------------------------------------------------------------------------------

Alternate Approach: Binary Search + Two Pointers Expansion

Idea:
1) Since the array is sorted, first find the position closest to x.
   - Use binary search to find the first index `right` such that arr[right] >= x.
   - Set `left = right - 1`.
   - Now x lies between arr[left] and arr[right] (or near one edge).

2) Expand outwards using two pointers:
   - While we still need k elements:
       - Compare |arr[left] - x| and |arr[right] - x|
       - If left is closer (or equal → prefer smaller value), take arr[left] and move left--
       - Else take arr[right] and move right++
   - If one side is exhausted, take remaining elements from the other side.

3) Sort the collected elements at the end (since we picked from both sides),
   or build them in correct order if you append carefully.

Time Complexity:
- O(log n) for initial binary search
- O(k) for expanding and choosing k closest
- O(k log k) if you sort at the end (can be avoided if you insert in order)
Overall:
- Typically O(log n + k), same class as the window binary search method.
---------------------------------------------------------------------------------------------

Comparison vs Window Binary Search:
- Window Binary Search (Optimal solution):
    - Directly finds the final contiguous window.
    - Cleaner, no extra sorting, very interview-friendly.
- Two-pointer Expansion:
    - Intuitive "grow from the closest" idea.
    - Needs care to maintain order; can be slightly messier.

Author: Teja Nayani
Date  : 9 November, 2025
*/

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0, right = n-k;
        while(left < right){
            int mid = left + (right - left)/2;
            //assume two windows - window A: [mid .. mid + k - 1], window B: [mid + 1 .. mid + k] (shifted one step to the right) 
            if(x - arr[mid] > arr[mid+k] - x){ //compare two windows
                left = mid + 1; //left edge is farther - i.e window B is closer - move towards right
            }else{
                right = mid;    //right edge is farther - i.e window A is closer - move towards left 
            }
        }
        int start = left; //left == right by the end of BS - so anything works :)

        List<Integer> res = new ArrayList<>();
        while(k-- > 0){
            res.add(arr[start++]);
        }
        return res;

        /* Alternate approach : Binary Search + Two Pointers Expansion

        int n = arr.length;
        int left = 0, right = n-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] >= x){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        left = right - 1;
        List<Integer> res = new ArrayList<>();
        int idx = 0;

        while(left >= 0 && right < n && k > 0){
            if(Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)){
                res.add(arr[left--]);
            }else{
                res.add(arr[right++]);
            }
            k--;
        }
        while(left >= 0 && k > 0){
            res.add(arr[left--]);
            k--;
        }
        while(right < n && k > 0){
            res.add(arr[right++]);
            k--;
        }
        Collections.sort(res);
        
        return res;*/
    }
}
