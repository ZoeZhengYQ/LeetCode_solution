class Solution {
    // DP(i, j) -> cost to convert word1(0, i) to word2(0, j)
    // 1. word1(i) = w2(j)
    //      DP(i, j) = DP(i-1, j-1)
    // 2. word1(i) != word2(j)
    //      DP(i, j) = min(DP(i-1,j-1), DP(i-1,j), DP(i, j-1)) + 1;
    // 多一维表示空w1 w2
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        
        int n = word1.length();
        int m = word2.length();
        
        int[][] cost = new int[n + 1][m + 1];
        
        // initialize
        for(int i = 0; i <= n; i++)
            cost[i][0] = i;
        for(int i = 1; i <= m; i++)
            cost[0][i] = i;
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    cost[i][j] = cost[i-1][j-1];
                } else {
                    cost[i][j] = Math.min(Math.min(cost[i-1][j-1], cost[i][j-1]), cost[i-1][j]) + 1;
                }
            }
        }
        return cost[n][m];
    }
}