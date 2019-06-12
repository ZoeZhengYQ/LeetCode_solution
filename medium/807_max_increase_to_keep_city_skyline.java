class Solution {
    // Time: O(mn)
    // Use % and / to prevent iterating too much times
    // 1ms, 100%
    
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int total = x * y;
        
        int[] arrX = new int[x];
        for (int i = 0; i < x; ++i) {
            arrX[i] = 0;
        }
        
        int[] arrY = new int[y];
        for (int j = 0; j < y; ++j) {
            arrY[j] = 0;
        }
        
        for (int t = 0; t < total; ++t) {
            // Compare x line
            int rowX = t / y;
            int colX = t % y;
            
            if (grid[rowX][colX] > arrX[rowX]) {
                arrX[rowX] = grid[rowX][colX];
            }
            
            
            // Compare y line
            int rowY = t % x;
            int colY = t / x;
            
            if (grid[rowY][colY] > arrY[colY]) {
                arrY[colY] = grid[rowY][colY];
            }
        }
        
        int res = 0;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                res += (Math.min(arrX[i], arrY[j]) - grid[i][j]);
            }
        }
        return res;
    }
}