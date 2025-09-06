/*
Problem: Product of Array Except Self
Leetcode: https://leetcode.com/problems/product-of-array-except-self/

Approach: Prefix + Suffix Product (O(1) Extra Space)
----------------------------------------------------
- Goal: For each index `i`, compute the product of all elements except `nums[i]`.
- Idea: Use prefix product (left of `i`) and suffix product (right of `i`) without extra space.
- Step 1: Fill result[i] with prefix product till index i–1.
- Step 2: Multiply result[i] with suffix product from index i+1 till end.

Time Complexity: O(n)
    - One forward pass for prefix product.
    - One backward pass for suffix product.

Space Complexity: O(1) (excluding output array)
    - No separate prefix/suffix arrays used — only one result array and a scalar.

Accepted in Leetcode — no division used and handles zeros correctly.

-----------------------------------------------------------------

Alternate Approach: Using Prefix and Suffix Arrays
----------------------------------------------------
- Construct prefixProduct[i] and suffixProduct[i] arrays separately.
- For result[i], multiply prefixProduct[i-1] * suffixProduct[i+1].

Time Complexity: O(n)
Space Complexity: O(n) extra (prefix + suffix arrays)

Drawback:
- Uses additional space → not optimal when O(1) is expected in interviews.

------------------------------------------------------------------

Notes:
- Division is **not allowed** as per problem constraints.
- This O(1) space solution is the most **interview-optimal** and clean.

*/

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int[] result = new int[n];
        
        // Optimal approach
        result[0] = 1; // Nothing before index 0

        // Step 1: Build prefix product
        for(int i = 1 ; i < n; i++){
            result[i] = result[i-1]*nums[i-1];
        }

        // Step 2: Multiply with suffix product (in reverse)
        int suffixProduct = 1;
        for(int i = n-2; i >= 0 ; i--){
            suffixProduct*=nums[i+1];
            result[i] = result[i]*suffixProduct;
        }

        return result;       


        /* Alternate Approach: Using Prefix & Suffix Arrays
        
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];

        prefixProduct[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixProduct[i] = nums[i]*prefixProduct[i-1];
        }

        suffixProduct[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            suffixProduct[i] = nums[i]*suffixProduct[i+1];
        }

        int[] result = new int[n];

        result[0] = suffixProduct[1];
        result[n-1] = prefixProduct[n-2];

        for(int i = 1; i < n-1; i++){
            result[i] = prefixProduct[i-1]*suffixProduct[i+1];
        }

        return result;*/

    }
}

