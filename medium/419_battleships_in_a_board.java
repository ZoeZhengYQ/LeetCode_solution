class Solution {
    // DFS
    // Also eliminate the invalid input
    // If a node has no horizontal and vertical neibor, 
    //     that's the end of the ship so we can verify if we need to add to count
    // If a note has both, that means this island is not valid for a boat
    //      so we pass invalid value and just set the rest of the node to be "."
    
    private int count = 0;
    private int[] xDis = new int[]{-1, 0, 1, 0};
    private int[] yDis = new int[]{0, -1, 0, 1};
    
    public int countBattleships(char[][] board) {
        int xLen = board.length;
        int yLen = board[0].length;
        for (int x = 0; x < xLen; ++x) {
            for (int y = 0; y < yLen; ++y) {
                if (board[x][y] == 'X') {
                    helper(board, x, y, true);
                }
            }
        }
        return count;
    }
    
    private void helper(char[][] board, int x, int y, boolean valid) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'X') 
            return;
        
        board[x][y] = '.';
        
        boolean verFlg = false, horFlg = false;
        // Vertical
        if ((x > 0 && board[x-1][y] == 'X') || 
            (x < board.length-1 && board[x+1][y] == 'X')) {
            verFlg = true;
        }
        if ((y > 0 && board[x][y-1] == 'X') || 
            (y < board[0].length-1 && board[x][y+1] == 'X')) {
            horFlg = true;
        }
        if (!verFlg && !horFlg && valid) {
            count++;
        } else {
            for (int i = 0; i < 4; ++i) {
                helper(board, x+xDis[i], y+yDis[i], !(verFlg && horFlg));
            }
        }
    }
}