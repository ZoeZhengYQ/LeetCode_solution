class Solution {
    // DFS, find a string to represent each shape of island
    // Remember to add "back" to string to distinguish some distinct island
    // Example: [[1,1,0],[0,1,1],[0,0,0],[1,1,1],[0,1,0]]
    // Can set grid[x][y] to 0 after visited so that we don't need to use visited set
    // Time: O(mn)
    // Space: O(mn)
    private int[] xDis = new int[]{-1, 0, 1, 0};
    private int[] yDis = new int[]{0, -1, 0, 1};
    private char[] dir = new char[]{'u', 'l', 'd', 'r'};
    
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        int xLen = grid.length, yLen = grid[0].length;
        Set<String> islands = new HashSet<>();
        
        for (int x = 0; x < xLen; ++x) {
            for (int y = 0; y < yLen; ++y) {
                if (grid[x][y] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(sb, x, y, grid, 'o');  // Origin
                    islands.add(sb.toString());
                }
            }
        } 
        return islands.size();
    }
    
    private void dfs(StringBuilder sb, int x, int y, int[][] grid, char direction) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) { 
            return ;
        }
        
        sb.append(direction);
        grid[x][y] = 0;
        for (int i = 0; i < 4; ++i) {
            dfs(sb, x+xDis[i], y+yDis[i], grid, dir[i]);
        }
        sb.append('b'); // Backwards
    }
}