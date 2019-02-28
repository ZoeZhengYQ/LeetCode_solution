class Solution {
// 多开一维表示空的s和p
// DP[i][j] 是指 s到i 和 p到j 互相match
// 1. s[i] 和 p[j] match || p[i] == '?'
//      看DP[i-1][j-1]是不是match
// 2. p[i] 是 ‘*’
//      看*是代表当前这位还是*代表空
// 3. 不match直接是false
// Time: O(mn)
// Space: O(mn)
    public boolean isMatch(String s, String p) {
        if ((s == null || s.length() == 0) && (p == null || p.length() == 0)) return true;
        else if (p == null || p.length() == 0) return false;
        
        p = p.replaceAll("\\*+", "*");
        int m = s.length();
        int n = p.length();
        boolean[][] match = new boolean[m+1][n+1];
        
        if (p.charAt(0) == '*') {
            match[0][1] = true;
        }
        match[0][0] = true;
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
                    match[i][j]=match[i-1][j-1];
                } else if(p.charAt(j-1) == '*')
                        match[i][j] = match[i-1][j] || match[i][j-1];
                else
                    match[i][j] = false;
            }
        }
        return match[m][n];
    }
}