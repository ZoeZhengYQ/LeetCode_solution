class Solution {
    // Naive check method
    // Time: O(n^2)
    // Space: O(1)
    private int maxLen = 0;
    private int start = 0;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        
        for (int i = 0; i < len; ++i) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i + 1);
        }
        
        return s.substring(start, start+maxLen);
    }
    
    private void checkPalindrome(String s, int pos1, int pos2) {
        while (pos1 >= 0 && pos2 < s.length() && s.charAt(pos1) == s.charAt(pos2)) {
            pos1--;
            pos2++;
        }
        
        int curLen = pos2 - pos1 - 1;
        
        if (maxLen < curLen) {
            start = pos1 + 1;   // already -1
            maxLen = curLen;
        }
    }
}