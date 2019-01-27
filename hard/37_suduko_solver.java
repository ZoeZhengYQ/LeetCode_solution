class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        solver(board);
    }
    
    private boolean solver (char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; ++c) {
                        if (checkValidity(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (solver(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkValidity (char[][] board, int rowIdx, int colIdx, char c) {
        for (int i = 0; i < 9; ++i) {
            // check row
            if (board[i][colIdx] == c) return false;
            // check col
            if (board[rowIdx][i] == c) return false;
            // check block
            int topLeftRow = 3 * (rowIdx / 3);
            int topLeftCol = 3 * (colIdx / 3);
            if (board[topLeftRow + i/3][topLeftCol + i%3] == c) return false;
        }
        return true;
    }
}