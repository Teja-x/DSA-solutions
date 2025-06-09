/*
Problem: First Non-Repeating Character in a String
Link: https://leetcode.com/problems/first-unique-character-in-a-string/

Approaches Implemented:
1. HashMap to count frequency and check in second pass
2. Fixed-size count array for lowercase letters
3. Queue-based approach to track first unique in streaming fashion - one(single) pass to main string , avoids two pass - queue + count[]

Time Complexity:
- All approaches: O(n)
Space Complexity:
- HashMap / Queue: O(1) due to fixed alphabet size (26)

Author: Teja Nayani
Date: June 9, 2025
*/
import java.util.LinkedList;
import java.util.Queue;

class FirstNonRepeatingCharacter {
    public int firstUniqChar(String s) {

        /* Approach 1 : HashMap to count frequency and check in second pass
        HashMap<Character,Integer> resultMap = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            resultMap.put(ch, resultMap.getOrDefault(ch,0)+1);
        }
    
        for(int i = 0 ; i < s.length() ; i++){
            if(resultMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;*/

        /* Approach 2 : Fixed size (26) count array for lowercase letters
        int countOfChar[] = new int[26];
        for(int i =0 ; i < s.length() ; i++){
            countOfChar[s.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < s.length() ; i++){
            if((countOfChar[s.charAt(i) - 'a']) == 1){
                return i;
            }
        }
        return -1;*/

        /*Approach 3 :  Queue + Count -based approach to track first unique in streaming fashion - one pass*/
        Queue<Character> queue = new LinkedList<>();
        int countOfChar[] = new int[26];
        for(char ch : s.toCharArray()){
            countOfChar[ch - 'a']++;
            queue.offer(ch);

            while(!queue.isEmpty() && countOfChar[queue.peek() - 'a']>1){
                queue.poll();
            }
        }
        while(!queue.isEmpty()){
            char firstNonRepeating = queue.peek();
            return s.indexOf(firstNonRepeating);
        }
        return -1;
    }
}