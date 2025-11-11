/*
Problem     : Time Based Key-Value Store
LeetCode    : https://leetcode.com/problems/time-based-key-value-store/

Goal:
Design a data structure that stores key-value pairs along with timestamps and 
allows retrieval of the value corresponding to the largest timestamp ≤ given timestamp.

Explanation:
----------------------------------------------------
1) Data Structure:
   - Use a HashMap<String, List<Pair>>.
     Each key maps to a list of (timestamp, value) pairs sorted by timestamp.

2) `set(key, value, timestamp)`:
   - Append (timestamp, value) to the list.
   - Use `map.computeIfAbsent(key, k -> new ArrayList<>())` for clean insertion.

3) `get(key, timestamp)`:
   - Perform binary search on the list for the given key.
   - Find the largest timestamp ≤ given timestamp.
   - Return the corresponding value, or an empty string if not found.

4) Binary Search Logic:
   - Initialize left = 0, right = list.size() - 1.
   - While left ≤ right:
        mid = left + (right - left) / 2
        if (list[mid].time ≤ timestamp):
            res = list[mid].val
            left = mid + 1   → search right to find larger timestamp ≤ target
        else:
            right = mid - 1
   - Return res.

Time Complexity:
   set() → O(1)  (append operation)
   get() → O(log n)  (binary search per key)
Space Complexity: O(N)
   - N = total number of key-value entries

Author: Teja Nayani  
Date  : 8 November, 2025
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeBasedKeyValueStore {

    class Pair{
        int time;
        String val;
        Pair(int time, String val){
            this.time = time;
            this.val = val;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        /*
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(timestamp, value));
        map.put(key, list);
        */
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";

        List<Pair> list = map.get(key);

        int left = 0, right = list.size()-1;
        String res = "";
        while(left <= right){
            int mid = left + (right - left)/2;
            if(list.get(mid).time <= timestamp){
                res = list.get(mid).val;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;        

        /*
        while(left < right){
            int mid = left + (right - left + 1)/2; // upper mid   i.e (ceil : (a + b - 1)/b )
            if(list.get(mid).time <= timestamp){
                left = mid; // mid is valid (<= ts), try to go right
            }else{
                right = mid - 1; // too big, go left
            }
        }
        return (list.get(left).time > timestamp) ? "" : list.get(left).val;
        */    
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */