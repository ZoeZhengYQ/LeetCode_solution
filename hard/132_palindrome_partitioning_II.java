class Solution {
    // Time: O(n^2)
    // Space: O(n^2)
    // like palindrome partitioning I
    //  use a 2D array to store palindrome result
    // use a 1D array to store min cut to reach a point
    // Final result is cut[len-1]
    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int[] cut = new int[len];
        Arrays.fill(cut, Integer.MAX_VALUE);
        
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    cut[i] = (j == 0) ? 0 : Math.min(cut[i], cut[j-1] + 1);
                }
            }
        }
        return cut[len-1];
    }
}