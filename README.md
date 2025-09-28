# DSA Solutions by Teja Nayani

Welcome to my personal repository of **Data Structures and Algorithms (DSA)** solutions written in **Java**.  
This repo is part of my focused journey to crack Full Stack Developer interviews by the end of 2025. 🚀

Each solution is written with clean, readable code and contains categories like Arrays, Strings, Hashing, and more.

---

## Folder Structure

Each topic has its own folder for clarity:

- `Arrays/` → Problems related to array manipulation
- `Strings/` → Problems involving string operations
- (More coming soon: LinkedLists, Recursion, HashMaps, Trees, etc.)

---

## Tech Stack

- **Language:** Java  
- **IDE:** Visual Studio Code  
- **Version Control:** Git + GitHub  

---

## My Goal

To master DSA fundamentals and enhance coding fluency for SDE roles by **September–November 2025**.  
I’ll keep updating this repo with more optimized solutions and advanced topics.

---

## ✨ Feel Free to Explore!

If you're on the same journey, feel free to **fork, star, or refer** to these solutions.  
Let’s grow together 💪

---

## Problems Included

| 🗂 Category | 📄 File | 🔍 Description |
|------------|---------|----------------|
| Arrays     | `ContainsDuplicate.java` | Checks if an array contains any duplicate element |
| Arrays     | `FindDuplicatesInArray.java` | Finds all duplicate numbers in an array |
| Arrays     | `LongestConsecutiveSequence.java` | Finds the length of the longest sequence of consecutive integers using a `HashSet` (O(n)). |
| Arrays | `BestTimeToBuyAndSellStock.java` | Calculates the maximum profit from a single buy-sell transaction by tracking the lowest price and maximum gain so far. |
| Arrays     | `TwoSum.java` | Returns indices of two numbers that sum to a target (hash map, O(n)) |
| Arrays     | `TwoSumII.java` | Returns indices (1-based) of two numbers in sorted array that sum to a target using two pointers. |
| Arrays     | `ThreeSum.java` | Finds all unique triplets that sum to 0 using sorting + two pointers, with duplicate skips. |
| Arrays | `FourSum.java` | Finds all unique quadruplets that sum to a given target using two nested loops + two pointers, with early pruning and duplicate handling. |
| Arrays      | `ProductOfArrayExceptSelf.java` | For each index, returns product of all other elements without division (prefix/suffix products, O(n) time, O(1) extra space). |
| Arrays      | `TopKFrequentElements.java`     | Finds the k most frequent elements (bucket sort O(n) or min-heap O(n log k)). |
| Arrays | `ValidSudoku.java` | Checks if a given 9×9 Sudoku board is valid using row/column/box tracking (boolean arrays). |
| Arrays | `MergeSortedArray.java` | Merges two sorted arrays in-place using 3-pointer technique (from end), avoiding extra space. |
| Arrays | `IntersectionOfTwoArraysII.java` | Finds intersection of two arrays (with duplicates) using frequency array optimized based on smaller input. |
| Arrays | `MoveZeroes.java` | Moves all zeros to the end while preserving order of non-zero elements using zero count shift method. |
| Arrays | `MajorityElement.java` | Uses Boyer-Moore Voting Algorithm to find the element appearing more than n/2 times. |
| Arrays | `RemoveElement.java` | Removes all instances of a given value from the array in-place and returns the new valid length. |
| Arrays | `PlusOne.java` | Adds one to a number represented as an array of digits, handling carry and overflow cases. |
| Arrays | `AddBinary.java` | Adds two binary strings using two-pointer and carry logic, returns result as binary string. |
| Greedy | `BestTimeToBuyAndSellStockII.java` | Maximizes profit by summing all increasing consecutive pairs (greedy approach). |
| Strings | `CountPalindromicSubstrings.java` | Counts all palindromic substrings using center expansion method (odd and even length). |
| Strings | `LongestSubstringWithoutRepeatingChars.java` | Uses sliding window with last seen character map to find longest substring without repeating characters. |
| Strings     | `ValidAnagram.java`             | Checks if two strings are anagrams (frequency count using hash map / count array; O(n) time). |
| Strings     | `GroupAnagrams.java`            | Groups words that are anagrams using a hash map keyed by sorted string or char-count string key. |
| Strings     | `ReverseString.java` | Reverses the given string (character array) in-place |
| Strings    | `ValidPalindrome  .java` | Validates if a string is a valid palindrome (ignores cases, symbols) |
| Strings    | `FirstNonRepeatingCharacter.java` | Finds the index of the first non-repeating character |
| Strings    | `EncodeDecodeStrings.java` | Encodes a list of strings into one string and decodes it back (used for data transmission). |
| Strings / Sliding Window | `LongestSubstringWithoutRepeatingChars.java` | Uses sliding window with character frequency map to track longest substring with unique characters. |
| Strings | `MinWindowSubstring.java` | Finds the smallest window in `s` which contains all characters of `t` using sliding window and frequency array. |
| Strings | `PermutationInString.java` | Checks if a permutation of `s1` exists as a substring in `s2` using fixed-size sliding window and frequency match. |
| Strings | `FindAllAnagramsInString.java` | Finds all starting indices of anagrams of `p` in `s` using sliding window and character count matching. |
| Two Pointers | `ContainerWithMostWater.java` | Uses two-pointer technique from both ends to find max water container formed by vertical lines. |
| Two Pointers / Prefix Max | `TrappingRainWater.java` | Calculates total trapped water using two pointers and running left/right max heights. |
| Strings / Two Pointers | `BackspaceStringCompare.java` | Compares two strings after processing backspaces using right-to-left traversal and skip counters. |
| Arrays / In-place | `RemoveDuplicatesFromSortedArray.java` | Removes duplicates in sorted array in-place and returns new length using a write pointer. |
| Sliding Window | `MinimumSizeSubarraySum.java` | Finds minimum length subarray with sum ≥ target using variable-sized sliding window. |
| Prefix Sum / HashMap | `SubarraySumEqualsK.java` | Counts subarrays that sum to `k` using prefix sum and a hashmap to store frequencies. |
| Sliding Window / Array | `LongestSubarrayAfterDeletingOne.java`    | Finds the longest subarray of 1s after deleting one element using sliding window and frequency count. Handles edge case where entire array is 1s. |
| Sliding Window / Array | `LongestMountainInArray.java`             | Detects mountain peaks and expands left and right to calculate mountain length. Returns max valid mountain length (length ≥ 3).                   |
| Sliding Window / Array | `MaxConsecutiveOnesIII.java`              | Finds the maximum number of consecutive 1s in a binary array if at most `k` 0s can be flipped using sliding window with frequency array.         |
| Stack             | `ValidParentheses.java`                | Uses a stack to match open/close parentheses. Push opening brackets, pop and validate against closing ones. Checks for leftover items in the stack.         |
| Stack             | `MinStack.java`                        | Maintains two stacks: one for normal push/pop, one for tracking current min. Push same min again if not replaced. Enables constant-time getMin().           |
| Monotonic Stack   | `DailyTemperatures.java`               | For each temp, pop lower temps and calculate wait days. Push indices into stack to track unresolved temps. Works forward or reverse.                         |
| Monotonic Stack   | `NextGreaterElementI.java`             | Finds next greater element for each in `nums1` from `nums2`. Uses stack to track decreasing elements, stores next greater in map, then maps to `nums1`.     |
| Stack             | `EvaluateRPN.java`                     | Evaluates RPN (postfix notation) expressions using a stack. Pops last two operands and applies operation. Supports all 4 basic arithmetic ops.               |
| Greedy + Sorting  | `CarFleet.java`                        | Sorts cars by position ascending. Iterates in reverse, calculating time to reach target. Increments fleet if new car can’t catch up with one ahead.          |
| Queue/Stack      | `ImplementQueueUsingStacks.java`     | Implements a queue using two stacks (`inStack`, `outStack`). Transfers elements only when needed to maintain FIFO order. Push O(1), pop amortized O(1). |
| Queue/Stack      | `ImplementStackUsingQueues.java`     | Implements a stack using a single queue (rotate elements on push) or two queues (costly push, cheap pop). Maintains LIFO behavior.               |
| Stack Simulation | `AsteroidCollision.java`             | Simulates asteroid collisions using a stack. Right-moving asteroids pushed directly; left-moving ones collide with stack top until resolved.     |
| Stack/Math Parsing | `BasicCalculatorII.java`       | Evaluates arithmetic expressions with +, -, *, / using a stack. Tracks last operator and builds numbers digit by digit. |
| Monotonic Stack    | `RemoveKDigits.java`           | Uses a monotonic stack to remove `k` digits, ensuring smallest possible number. Handles leading zeros and returns "0" if empty. |
| Monotonic Stack    | `NextGreaterElementII.java`       | Finds the next greater element for each number in a circular array using a stack. Returns -1 if none exists. |
| Monotonic Stack    | `StockSpanner.java`               | Online stock span problem. Uses stack of [price, span] pairs to compute span in amortized O(1). |
| Stack/Strings      | `SimplifyPath.java`               | Simplifies a Unix-style file path using a stack, handling `.` , `..`, and redundant slashes.     |
| Monotonic Stack    | `LargestRectangleInHistogram.java`| Computes largest rectangle in histogram using monotonic increasing stack. Efficient O(n) solution. |
---


