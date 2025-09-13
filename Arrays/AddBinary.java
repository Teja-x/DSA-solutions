/*
Problem: Add Binary  
LeetCode: https://leetcode.com/problems/add-binary/

Approach: Two-Pointer with Carry
--------------------------------------------
- Add two binary strings `a` and `b` and return the result as a binary string.
- Start from the end of both strings and simulate binary addition.
- Maintain a `carry` to track overflow at each bit.
- Append result bit-by-bit into a StringBuilder and reverse it at the end.

Logic:
- If sum is 0 → append '0', carry 0
- If sum is 1 → append '1', carry 0
- If sum is 2 → append '0', carry 1
- If sum is 3 → append '1', carry 1

Time Complexity: O(max(a.length, b.length))  
Space Complexity: O(max(a.length, b.length)) for the result string

Example:
Input  : a = "1010", b = "1011"  
Output : "10101"

Author: Teja Nayani  
Date  : September 12, 2025
*/

class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int p1 = a.length()-1, p2 = b.length()-1;
        int carry = 0, sum = 0;
        while(p1 >= 0 || p2 >= 0){
            sum = carry;
            if(p1 >= 0){
                sum += a.charAt(p1)-'0';
            }
            if(p2 >= 0){
                sum += b.charAt(p2)-'0';
            }
            if(sum == 0 || sum == 1){
                result.append(sum);
                carry = 0;
            }
            if(sum == 2){
                result.append(0);
                carry = 1;
            }
            if(sum == 3){
                result.append(1);
                carry = 1;
            }
            p1--;
            p2--;
        }
        if(carry == 1){
            result.append(1);
        }

        return new String(result.reverse());
    }
}