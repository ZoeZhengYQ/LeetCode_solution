class Solution {
    // DP
    // dp[i] means there is match from 0 to i
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        
        int len = s.length();
        boolean[] dp = new boolean[len];
        
        for (int i = 0; i < len; ++i) {
            // note it is j <= i! dont forget the =
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || dp[j - 1]) {
                    String subStr = s.substring(j, i + 1);
                    if (wordDict.contains(subStr)) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[len-1];
     }
}