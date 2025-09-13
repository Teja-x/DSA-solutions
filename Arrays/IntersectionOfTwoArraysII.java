/*
Problem: Intersection of Two Arrays II  
LeetCode: https://leetcode.com/problems/intersection-of-two-arrays-ii/

Approach: Frequency Array (Optimized for Known Range)
-------------------------------------------------------
- Goal: Return the intersection elements of two arrays (including duplicates), in any order.

Strategy:
- Use a **frequency count array** of size 1001 (given that input values are in range [0, 1000]).
- Count the occurrences of each number in the **smaller array** to optimize space.
- Traverse the other array and check if the number exists in the frequency array.
  - If yes, include it in the result and decrement the count.

Why this works well:
- This avoids sorting, keeping the time complexity linear.
- Using a frequency array instead of a map improves constant-time access.

Time Complexity: O(m + n) , where m = length of nums1, n = length of nums2

Space Complexity: O(1001) => effectively O(1)

Alternate Approach (Commented):
- Uses sorting + two pointers to find common elements.
- Slightly more generic but involves O(n log n) time due to sorting.

Example:
Input : nums1 = [1,2,2,1], nums2 = [2,2]  
Output: [2,2]

Author: Teja Nayani  
Date  : September 10, 2025
*/

class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] countArr = new int[1001];
        int n1=nums1.length, n2=nums2.length;
        int[] intersectArray = new int[Math.min(n1, n2)];
        int idx = 0;    
        if(n1<n2){
            for(int i = 0; i < nums1.length; i++){
                countArr[nums1[i]]++;
            }
            for(int i = 0; i < nums2.length; i++){
                if(countArr[nums2[i]] > 0){
                    intersectArray[idx++] = nums2[i];
                    countArr[nums2[i]]--;                   
                }
            }
        }else{
            for(int i = 0; i < nums2.length; i++){
                countArr[nums2[i]]++;
            }
            for(int i = 0; i < nums1.length; i++){
                if(countArr[nums1[i]] > 0){
                    intersectArray[idx++] = nums1[i];
                    countArr[nums1[i]]--;                 
                }
            }            
        }
        int[] result = Arrays.copyOf(intersectArray, idx);
        return result;

        /* alternate approach - not as optimal as sorting takes O(nlogn) each
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int n1 = nums1.length, n2 = nums2.length;
        int p1=0, p2=0;
        while(p1<n1 && p2<n2){
            if(nums1[p1] < nums2[p2]){
                p1++;
            }else if(nums2[p2] < nums1[p1]){
                p2++;
            }else{
                //list.add(nums1[p1]);
                while(p1<n1 && p2<n2 && nums1[p1] == nums2[p2]){
                    list.add(nums1[p1]);
                    p1++;
                    p2++;
                }
            }
        }
        // int[] result = list.stream()
        //                     .mapToInt(Integer::intValue)
        //                     .toArray();
        int[] result = new int[list.size()];
        int idx = 0;
        for(int ele  : list){
            result[idx++] = ele;
        }
        return result;*/
    }
}