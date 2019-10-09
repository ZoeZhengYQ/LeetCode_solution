class Solution {
    // Note: i + j = k, so don't need to add k to state.
    // DP: Mind the index!
    // Time: O(mn)
    // Space: O(mn)
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        
        boolean[][] dp = new boolean[arr1.length+1][arr2.length+1];
        dp[0][0] = true;
        for (int i = 1; i <= arr1.length; ++i) {
            if (arr1[i-1] == arr3[i-1] && dp[i-1][0]) dp[i][0] = true;
        }
        
        for (int j = 1; j <= arr2.length; ++j) {
            if (arr2[j-1] == arr3[j-1] && dp[0][j-1]) dp[0][j] = true;
        }
        
        for (int i = 1; i <= arr1.length; ++i) {
            for (int j = 1; j <= arr2.length; ++j) {
                int k = i+j-1;
                if (dp[i-1][j] && arr1[i-1] == arr3[k]) {
                    dp[i][j] = true;
                }
                if (dp[i][j-1] && arr2[j-1] == arr3[k]) {
                    dp[i][j] = true;
                }
            }
        }
        
        // for (boolean[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }
        return dp[arr1.length][arr2.length];
        
    }
    // top down DFS with memo
    /*
    private Map<String, Boolean> memo = new HashMap<>();
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        return dfs(arr1, arr2, arr3, 0, 0, 0);
    }
    
    private boolean dfs(char[] a1, char[] a2, char[] a3, int i, int j, int k) {
        String str = stateString(i, j);
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        if (k == a3.length) {
            memo.put(str, true);
            return true;   
        }
        if (i < a1.length && j < a2.length && a3[k] != a1[i] && a3[k] != a2[j]) {
            memo.put(str, false);
            return false;
        }
        boolean flg = false;
        if (i < a1.length && a3[k] == a1[i]) {
            flg |= dfs(a1, a2, a3, i+1, j, k+1);
        }
        if (j < a2.length && a3[k] == a2[j]) {
            flg |= dfs(a1, a2, a3, i, j+1, k+1);
        }
        memo.put(str, flg);
        return flg;
    }
    
    private String stateString(int i, int j) {
        return i + " " + j;
    }
    */
}