/*
Problem: Encode and Decode Strings
NeetCode: https://neetcode.io/problems/string-encode-and-decode

Approach: Length-Prefix Encoding
--------------------------------------
- Goal: Encode a list of strings into one string so that it can be decoded back.
- Idea: For each string, store the length + '#' + actual string.
        This way, decoding is possible without confusion (even if strings contain special characters).
- Step 1: Append s.length() + '#' + s to the result string during encoding.
- Step 2: While decoding, read length till '#' → fetch that many characters after '#'.

Time Complexity:
- Encoding: O(n) for total characters across all strings.
- Decoding: O(n) for parsing and reconstructing all strings.

Space Complexity: O(n) for the encoded and decoded outputs.

✅ Safe for all characters including '#' and ',' — does not rely on delimiters alone.

-----------------------------------------------------------------

Notes:
- Always prefer length-prefix encoding when dealing with arbitrary characters.
- This approach is safe, clean, and interview-approved.

Author: Teja Nayani
Date: September 7, 2025
*/

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }

            int strLength = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + 1 + strLength));
            i = j + 1 + strLength;
        }

        return result;
    }
}
