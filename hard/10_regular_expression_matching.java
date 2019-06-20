class Solution {
    // Buttom up DP solution
    // One more row and col to represent empty s and p
    // Time: O(mn)
    // Space: O(mn)
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        
        // Do not need to initialize false
        boolean[][] T = new boolean[sLen+1][pLen+1];
        T[0][0] = true;
        
        // 注意这个初始化，是s为""，看pattern是否满足
        // 如果是a*b*c*的形式就都是满足的
        for (int j = 0; j < pLen; ++j) {
            if (p.charAt(j) == '*') {
                T[0][j+1] = T[0][j-1];
            }
        }
        
        for (int i = 0; i < sLen; ++i) {
            for (int j = 0; j < pLen; ++j) {
                // Same char or pattern is '.'
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    T[i+1][j+1] = T[i][j];
                    continue;
                }
                // Pattern is '*'
                if (p.charAt(j) == '*') {
                    // 0 occurance
                    if (j >= 2 && T[i+1][j-1]) {
                        T[i+1][j+1] = T[i+1][j-1];
                        // System.out.println("i:" + i + " j:" + j + " 0 occur");
                        continue;
                    }
                    // Check if current char in s is the same as 
                    // the previous char in pattern
                    if (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                        T[i+1][j+1] = T[i][j+1];
                        // System.out.println("i:" + i + " j:" + j + " other");
                        continue;
                    }
                } 
                T[i+1][j+1] = false;
            }
        }
        return T[sLen][pLen];
    }
}