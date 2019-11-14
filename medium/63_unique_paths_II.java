class Solution {
    // DP
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        // Init for case 0
        for (int i = 0; i < n; ++i) {
            if (obstacleGrid[0][i] == 1) break;
            dp[i] = 1;
        }
        
        // Note that we start from 1!
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += (j == 0) ? 0 : dp[j-1];
                }
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[n-1];
    }
}