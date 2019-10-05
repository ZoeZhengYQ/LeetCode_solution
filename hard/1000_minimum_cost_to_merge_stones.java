class Solution {
    // DP
    // Time: O(N^3)
    // Space: O(KN^2)
    public int mergeStones(int[] stones, int K) {
        int len = stones.length;
        if ((len-1) % (K-1) != 0) return -1;    // Impossible task
        
        int[] sum = new int[len+1];
        for (int i = 1; i <= len; ++i) {
            sum[i] = sum[i-1] + stones[i-1];
        }
        
        // Initial State
        int[][][] dp = new int[len][len][K];
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                for (int k = 0; k < K; ++k) {
                   dp[i][j][k] = 99999999; // Should not set to max value, would become MIN_VALUE once +1
                }   
            }
        }
        for (int i = 0; i < len; i++) {
            dp[i][i][0] = 0;
        }
        
        for (int l = 2; l <= len; ++l) { // Length of interval
            for (int i = 0; i <= len-l; ++i) {
                int j = i + l - 1;
                for (int k = 1; k < K; ++k) {
                    for (int t = i; t < j; ++t) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][t][k - 1] + dp[t + 1][j][0]);
                    }
                }
                dp[i][j][0] = dp[i][j][K-1] + sum[j+1] - sum[i];   
            }
        }
        return dp[0][len-1][0];
    }
}