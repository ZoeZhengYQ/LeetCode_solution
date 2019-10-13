class Solution {
    // DFS, use a skip to record node that should not skip
    private int[][] skip;
    
    public int numberOfPatterns(int m, int n) {
        skip = new int[10][10];
        // Horizontal
        skip[1][3] = skip[3][1] = 2;
        skip[4][6] = skip[6][4] = 5;
        skip[7][9] = skip[9][7] = 8;
        // Vertical
        skip[1][7] = skip[7][1] = 4;
        skip[2][8] = skip[8][2] = 5;
        skip[3][9] = skip[9][3] = 6;
        // Diagonal
        skip[1][9] = skip[9][1] = 5;
        skip[3][7] = skip[7][3] = 5;
        
        boolean[] visited = new boolean[10];
        visited[0] = true;
        
        int res = 0;
        for (int r = m; r <= n; ++r) {
            res += helper(visited, r-1, 1) * 4; // 1, 3, 7, 9 are symmetric
            res += helper(visited, r-1, 2) * 4; // 2, 4, 6, 8 are symmetric
            res += helper(visited, r-1, 5);     // 5
        }
        return res;
        
    }
    
    private int helper(boolean[] visited, int rem, int idx) {
        if (rem < 0) return 0;
        if (rem == 0) return 1;
        
        int res = 0;
        visited[idx] = true;
        for (int i = 1; i <= 9; ++i) {
            if (!visited[i] && visited[skip[idx][i]]) {
                res += helper(visited, rem-1, i);
            }
        }
        visited[idx] = false;
        return res;
    }
}