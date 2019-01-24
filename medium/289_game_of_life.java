class Solution {
    
    // do it in-place by using 2 bits to represent old and new status
    // 00: dead(new), dead(old)
    // 01: dead(new), live(old)
    // 10: live(new), dead(old)
    // 11: live(new), daed(old)
    // 00 and 01 could be ignore because they do not change current value
    // 
    // to get old status, simply
    //      board[i][j] & 1;
    // to get new status, simply
    //      board[i][j] >> 1;
    public void gameOfLife(int[][] board) {
        if (board == null || board[0].length == 0) return;
        
        int r = board.length;
        int c = board[0].length;
        
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                int cnt = countLives(board, i, j);
                
                // leave case 00 and 01, because there is no changes
                if (board[i][j] == 1 && cnt <= 3 && cnt >= 2)
                    board[i][j] = 3;
                
                if (board[i][j] == 0 && cnt == 3) 
                    board[i][j] = 2;
            }
        }
        
        for (int i = 0; i < r; ++i) 
            for (int j = 0; j < c; ++j) 
                board[i][j] >>= 1;
    }
    
    
    /* Function to count live cells around cell (x, y) */
    private int countLives(int[][] board, int x, int y) {
        int lives = 0;
        int r = board.length;
        int c = board[0].length;
        for (int i = Math.max(x-1, 0); i <= Math.min(x+1, r-1); ++i) {
            for (int j = Math.max(y-1, 0); j <= Math.min(y+1, c-1); ++j) {
                lives += board[i][j] & 1;
            }
        }
        lives -= board[x][y] & 1;
        
        return lives;
    }
}