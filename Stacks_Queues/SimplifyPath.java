/* 
Problem    : Simplify Path
LeetCode   : https://leetcode.com/problems/simplify-path/

Goal       : Given an absolute path for a file in Unix-style, return the canonical path.
             The canonical path must follow these rules:
             - Always starts with a single '/'.
             - Any two directories are separated by a single '/'.
             - Does not end with a trailing '/'.
             - Ignores '.' (current directory).
             - '..' means going one level up (pop from stack if possible).
             - Multiple consecutive '/' are treated as a single '/'.

Approach   : Stack (Split + Processing Components)
---------------------------------------------------
- Split the input path using '/' as delimiter.
- Traverse each component:
    • Skip empty strings and '.' (stay in the same directory).
    • If component is '..', pop from stack (go one directory up).
    • Otherwise, push the directory name into the stack.
- Reconstruct the canonical path from stack (joining with '/').

Why it Works?
- Stack mimics directory traversal: push for deeper directories, pop for going up.
- Handles redundant slashes and ignores '.' correctly.
- Guarantees a clean, simplified absolute path.

Time Complexity   : O(n) 
    - Each component is processed once.
Space Complexity  : O(n)
    - Stack stores valid path components.

Example:
Input  : "/home/../usr//bin/"
Output : "/usr/bin"

Input  : "/../"
Output : "/"

Author   : Teja Nayani
Date     : September 23, 2025
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");
        int n = components.length;
        for(String comp : components){
            if(comp.isEmpty() || comp.equals(".")){
                continue;
            }else if(comp.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(comp);
            }
        }

        if(stack.isEmpty())
            return "/";

        StringBuilder simplifiedPath = new StringBuilder();
        while(!stack.isEmpty()){
            simplifiedPath.append("/").append(stack.pollLast());
        }
        return simplifiedPath.toString();
    }
}
