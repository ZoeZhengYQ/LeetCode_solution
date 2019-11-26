class Solution {
    // BFS
    // Time: O(n)
    // Space: O(n)
    private int[] dx = new int[]{-1, 0, 1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};
    
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int rounds = 0, fresh_cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    fresh_cnt++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        int size = q.size();
        while (size > 0) {
            if (fresh_cnt == 0) return rounds;
            rounds++;
            for (int k = 0; k < size; ++k) {
                int[] rot = q.remove();
                for (int m = 0; m < 4; ++m) {
                    int newX = rot[0]+dx[m];
                    int newY = rot[1]+dy[m];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        q.add(new int[]{newX, newY});
                        fresh_cnt--;
                    }
                }
            }
            size = q.size();
        }
        return (fresh_cnt == 0) ? rounds : -1;
    }
}