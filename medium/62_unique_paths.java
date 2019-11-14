class Solution {
    // Simple dp
    // Time: O(mn)
    // Space: O(n)
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[j] += (j == 0) ? 0 : dp[j-1];   
            }
        }
        return dp[n-1];
    }
    /*
    // Top down DFS
    private Map<String, Integer> memo = new HashMap<>();
    
    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }
    
    private int dfs(int x, int y, int m, int n) {
        if (x >= m || y >= n) return 0;
        if (x == m-1 || y == n-1) { return 1; }
        String str = x + "," + y;
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        int res = 0;
        res += dfs(x, y+1, m, n);
        res += dfs(x+1, y, m, n);
        memo.put(str, res);
        return res;
    }
    */
}