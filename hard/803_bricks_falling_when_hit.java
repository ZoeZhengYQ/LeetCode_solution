class Solution {
    // DFS
    // -1: hit empty brick
    // 0: hit brick originally empty brick
    // 1: brick not hit
    // 2: visited connected brick
    // up right down left
    private int[] xDis = new int[]{-1, 0, 1, 0};
    private int[] yDis = new int[]{0, 1, 0, -1};
    
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        // remove hit bricks
        for (int[] brick : hits) {
            grid[brick[0]][brick[1]] -= 1;
        }
        
        // perform DFS for the top line
        for (int y = 0; y < grid[0].length; ++y) {
            dfsHelper(0, y, grid);
        }
        
        // reversely add back!
        for (int i = hits.length-1; i >= 0; --i) {
            int x = hits[i][0], y = hits[i][1];
            grid[x][y] += 1;
            if (grid[x][y] == 0 || !isConnectedToTop(x, y, grid)) continue;
            res[i] = dfsHelper(x, y, grid) - 1; // substract itself
        }
        return res;
        
    }
    
    private int dfsHelper(int x, int y, int[][] grid) {
        // Do not count:
        // 1. no brick
        // 2. visited bricks
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2; // visited
        int count = 1;
        for (int i = 0; i < 4; ++i) {
            count += dfsHelper(x+xDis[i], y+yDis[i], grid);
        }
        return count;
    }
    
    private boolean isConnectedToTop(int x, int y, int[][] grid) {
        if (x == 0) return true; // top line
        for (int i = 0; i < 4; ++i) {
            int newX = x+xDis[i], newY = y+yDis[i];
            if (newX >=0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 2) {
                return true;
            }
        }
        return false;
    }
    
    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------");
    }
}