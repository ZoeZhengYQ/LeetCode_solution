class Solution {
    // to traverse the whole grid
    // for i = 0 to 8
    // for j = 0 to 8
    // 1. traverse on row level: i, j
    // 2. traverse on col level: j, i
    // 3. traverse on block level:
    //      mark the top left element of a block
    //      rowIdx -> 3*(i/3)
    //      colIdx -> 3*(i%3)
    //      traverse the other element
    //      rowVal -> rowIdx+j/3
    //      colVal -> colIdx+j%3
    //      new HashSet might be faster then clear old set
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        for (int i = 0; i < 9; ++i) {
            Set row = new HashSet();
            Set col = new HashSet();
            Set blck = new HashSet();
            for (int j = 0; j < 9; ++j) {
                if (!row.add(board[i][j]) && board[i][j] != '.') return false;
                if (!col.add(board[j][i]) && board[j][i] != '.') return false;
                int rowIdx = 3*(i/3) + (j/3);
                int colIdx = 3*(i%3) + (j%3);
                if (!blck.add(board[rowIdx][colIdx]) && board[rowIdx][colIdx] != '.') return false;
            }
        }
        return true;
    }
    
    
    // mark number in row as number+row+rowIdx
    // mark number in col as number+row+colIdx
    // mark number in block as number+blck+blockCoordinate
    /*
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                if (board[i][j] <= '0' || board[i][j] > '9') return false;
                String mark = String.valueOf(board[i][j]);
                if (!seen.add(mark + "row" + i) || !seen.add(mark + "col" + j) || !seen.add(mark + "blck" + i/3 + "-" + j/3)) {
                    return false;
                }
            }
        }
        return true;
    }
    */
}