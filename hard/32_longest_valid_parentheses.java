class Solution {
    // DP solution
    // cases: 1. s[i] == '('  -> dp[i] = 0
    //        2. s[i] == ')'
    //              - s[i-1] == '('  ->  dp[i] = dp[i-2] + 2
    //              - s[i-1] == ')'  ->  dp[i-1] + 2 + dp[i-dp[i-1]-2]
    // Time: O(n)
    // Space: O(n)
    /*
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 2) { return 0; }
        int longest = 0;
        int[] dp = new int[len];
        
        for (int i = 1; i < len; ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = ((i-2)<0 ? 0 : dp[i-2]) + 2;
                } else {
                    if(i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                        dp[i] = dp[i-1] + 2 + (((i-dp[i-1]-2 >= 0) ? dp[i-dp[i-1]-2] : 0));
                    }
                }
                longest = Math.max(longest, dp[i]);
            }
        }
        return longest;
    } */
    
    // More concise version (less readability)
    // Combine the two cases to one
    //          Note that if s[i] == '(', dp[i] == 0
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 2) { return 0; }
        int longest = 0;
        int[] dp = new int[len];
        
        for (int i = 1; i < len; ++i) {
            if(s.charAt(i) == ')' && 
               i-dp[i-1]-1 >= 0 && 
               s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + 2 + ((i-dp[i-1]-2 >= 0) ? dp[i-dp[i-1]-2] : 0);
                    longest = Math.max(longest, dp[i]);
            }
        }
        return longest;
    }
}