/*
Problem: Top K Frequent Elements
Link: https://leetcode.com/problems/top-k-frequent-elements/

Approach 1: Bucket Sort (Optimized for frequency-based grouping)
- Count frequency of each element using a HashMap.
- Use a bucket array (List<Integer>[]) where index represents frequency.
- Collect elements from highest frequency downwards until k elements are gathered.

Time Complexity: O(n)
    - Building frequency map: O(n)
    - Filling bucket: O(n)
    - Collecting top k: O(n) in worst-case

Space Complexity: O(n)
    - HashMap + Bucket array + Result List

Note:
- Faster than heap-based approach when array size is large and k is small.
- Assumes nums.length >= k

Alternate Approach: Min Heap (Priority Queue)
- Use a HashMap to count frequencies of elements.
- Maintain a min-heap (PriorityQueue) of size k to keep track of top k frequent elements.
- If heap exceeds size k, remove the least frequent element.
- At the end, extract keys from heap into result array.

Time Complexity: O(n log k)
    - O(n) for frequency map construction
    - O(n log k) for maintaining heap of size k

Space Complexity: O(n)
    - O(n) for frequency map
    - O(k) for heap

Use Case:
- Efficient when k << n (very small k compared to array size).
- Better than bucket sort when frequency distribution is very skewed.

Note:
- Java's PriorityQueue uses a min-heap by default.
- Comparator `(a, b) -> a[1] - b[1]` sorts by frequency (value).

Example Heap Entry: [element, frequency]
    - Ex: [4, 2] means element `4` occurs `2` times.

Author: Teja Nayani
Date: September 5, 2025
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        
        HashMap<Integer, Integer> hm = new HashMap<>();    
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }    

        //Using Bucket array
        List<Integer>[] list = new ArrayList[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            int freq = entry.getValue();
            if(list[freq] == null){
                list[freq] = new ArrayList<>();
            }
            list[freq].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();
        for(int i = nums.length; i >= 0 && result.size() <= k; i--){
            if(list[i] != null){
                result.addAll(list[i]);
            }
        }

        int[] resArray = new int[k];
        for(int i = 0; i < k; i++){
            resArray[i] = result.get(i);
        }

        return resArray;
        /*return result.subList(0,k).stream()
                                  .mapToInt(Integer :: intValue)
                                  .toArray();
        */

        /* 
        
        Using minHeap/maxHeap        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        //PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        //for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
        //    maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        //}

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll()[0];
        }
        return result;
        */
    }
}
