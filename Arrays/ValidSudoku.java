/*
Problem: Valid Sudoku
Leetcode: https://leetcode.com/problems/valid-sudoku/

Approach: Hashing using 3 Boolean Matrices
---------------------------------------------
- Goal: Check if the current 9×9 Sudoku board is valid.
- Each digit (1-9) should appear only once in:
    1. Each row
    2. Each column
    3. Each 3×3 sub-box

- Strategy:
    - Use 3 boolean[][] arrays:
        - rows[9][9] tracks if digit d exists in row i
        - cols[9][9] tracks if digit d exists in column j
        - boxes[9][9] tracks if digit d exists in box index b

    - For every (i, j):
        - Skip if cell is '.' (empty)
        - Get digit = board[i][j] - '1'  (0-based index)
        - Calculate boxIndex = (i / 3) * 3 + (j / 3)
        - If digit already marked in any of the 3 trackers → return false
        - Else, mark the digit as used in row, col, and box

Time Complexity: O(1)
    - Always fixed size 9×9 → constant operations

Space Complexity: O(1)
    - Only uses 3 boolean[9][9] arrays

- Passes all edge cases — duplicates in row, column, or box.
- Does not attempt to solve the Sudoku — only checks current validity.

-------------------------------------------------------

Alternate Approach: Use Sets 
-------------------------------------------------------
- Use 3 arrays of Sets (HashSet<Integer>) for rows, cols, boxes.
- Instead of manually managing index math, use Set operations:
    - set.add(d) returns false if already present
- Slightly more readable but uses more memory than primitive arrays

Time Complexity: O(1)
Space Complexity: O(1)

-------------------------------------------------------

Notes:
- Box index formula is critical: `(i / 3) * 3 + (j / 3)`
- Make sure to subtract '1' from char to get 0-based digit index

Author: Teja Nayani
Date: September 7, 2025
*/

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean rows[][] = new boolean[9][9];
        boolean columns[][] = new boolean[9][9];
        boolean boxes[][] = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int digit;
                int b = ((i/3)*3) + (j/3);
                if(board[i][j] != '.'){
                    // convert char to 0-based index
                    digit = Character.getNumericValue(board[i][j]) -1; // digit = board[i][j] - '1'

                    if((rows[i][digit] == true) || (columns[j][digit] == true) || (boxes[b][digit] == true)){
                        return false;
                    }
                    
                    rows[i][digit] = true;
                    columns[j][digit] = true;
                    boxes[b][digit] = true;
                }
            }
        }
        return true;
    }
}