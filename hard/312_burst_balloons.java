class Solution {
    // DP
    // i = start, j = end
    // dp[i, j] = dp[i, k-1] + dp[k+1, j] + N[i-1][k][j+1]
    // Key: Add a 1 to begin and end to eliminate some cases
    // 因为打气球对前后有依赖，所以设置i为第一个打的不好，
    // 应该设置为最后一个打的，那就能将i和start还有end联系起来了
    // Time: O(n^3)
    // Space: O(n^2)
    public int maxCoins(int[] nums) {
        // 前后个加一个1
        int[] N = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) N[n++] = x;
        N[0] = N[n++] = 1;
        int[][] dp = new int[n][n];
        
        // n = nums.length + 2
        int size = nums.length;
        
        for (int len = 1; len <= size; ++len) {
            for (int start = 1; start <= size - len + 1; ++start) {
                // exclusive
                int end = start + len - 1;
                for (int k = start; k <= end; ++k) {
                    int coins = dp[start][k-1] + dp[k+1][end] + N[start-1] * N[k] * N[end+1];
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }
        return dp[1][n-2];
    }
}