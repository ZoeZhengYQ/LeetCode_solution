class Solution {
    // DP + Backtracking
    // Time: O(n^2 + 2^n)
    // Space: O(n^2)
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                // dp[j][i] is depend on dp[j+1][i-1]
                // if i == j, dp[j][i] == true
                // if s[i] == s[j] && j+1 == i: dp[j][i] == true
                // if s[i] == s[j] && i-j == 2: dp[j][i] == true
                if (s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(s, 0, new ArrayList<>(), dp);
        return res;
    }
    
    private void helper(String s, int start, List<String> temp, boolean[][] dp) {
        if (start >= s.length() && temp.size() > 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < s.length(); ++i) {
            if (dp[start][i]) {
                temp.add(s.substring(start, i+1));
                helper(s, i+1, temp, dp);
                temp.remove(temp.size()-1);
            }
        }
    }
    // Backtracking: DFS
    // Time: O(n* 2^n)
    /*
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(String s, int start, List<String> temp) {
        if (temp.size() > 0 && start >= s.length()) { // reach the end of the string
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < s.length(); ++i) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i+1));
                helper(s, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int l, int r) {
        if (l > r) return false;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    */
}