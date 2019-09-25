class Solution {
    // DFS
    // Time: O(mn)
    // Space: O(1)
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) { return 0; }
        int max = 0;
        for (int x = 0; x < grid.length; ++x) {
            for (int y = 0; y < grid[0].length; ++y) {
                if (grid[x][y] == 1) {
                    int cur = DFS(grid, x, y);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }
    
    private int DFS(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + DFS(grid, x+1, y) + DFS(grid, x-1, y) + DFS(grid, x, y+1) + DFS(grid, x, y-1);
    }
}