class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int count = 0;
        
        for (int i = 0; i < n; ++i) {
            int m = grid[i].length;
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1') {
                    mark(grid, i, j);
                    // one island only count once
                    count++;
                }
            }
        }
        return count;
    }
    
    // using recursion to check the 4 adjacent block to shink the island
    private void mark(char[][] c, int i, int j) {
        if (i < 0 || j < 0 || i >= c.length || j >= c[0].length || c[i][j] == '0') return;
        c[i][j] = '0';
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, -1, 0, 1};
        
        for (int k = 0; k < 4; ++k) {
            mark(c, i + x[k], j + y[k]);
        } 
    }
}