/*
Problem: Group Anagrams
Link: https://leetcode.com/problems/group-anagrams/

Approach 1: Sorting-Based Key
- For each string in the array:
    - Convert it to a character array and sort it.
    - Use the sorted string as a key in a HashMap.
    - Group all original strings with the same sorted key together.
- This works because all anagrams, once sorted, look the same.

Time Complexity: O(n * k log k)
    - n = number of strings
    - k = average length of each string (sorting each string takes O(k log k))
Space Complexity: O(n * k)
    - For storing the grouped anagrams in the hashmap

Note:
- Uses TimSort (combination of Merge Sort and Insertion Sort) under the hood via Arrays.sort()
- Alternate Approach: Use character count (convert it to String) as key to avoid sorting — better for large input sizes.

Author: Teja Nayani
Date: September 5, 2025
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        // HashMap to store sorted string as key and list of anagrams as values
        HashMap<String, List<String>> hm = new HashMap<>();

        for(int i = 0; i < strs.length; i++){ 
            char[] charStr = strs[i].toCharArray();
            Arrays.sort(charStr); // TimSort: O(k log k) for each string
            String key = new String(charStr); // sorted string is the key

            /* Alternate approach            
            int countArray[] = new int[26];
            for(char ch : strs[i].toCharArray()){
                countArray[ch - 'a']++;
            }
            char charArray[] = new char[26];
            for(int k = 0; k < 26; k++){
                charArray[k] = (char)countArray[k];
            }
            String key = new String(charArray);*/

            List list = hm.getOrDefault(key, new ArrayList()); // Get existing list or create a new one
            list.add(strs[i]);
            hm.put(key, list);
        }

        /*List<List<String>> result = new ArrayList<>(); 
        for(List<String> stringList : hm.values()){
            result.add(stringList);
        }
        return result;*/
        
        return new ArrayList(hm.values()); // Return all grouped anagrams
    }
}
