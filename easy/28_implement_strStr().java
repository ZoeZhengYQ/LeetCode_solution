class Solution {
    // more elegant version
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        for (int i = 0; ; ++i) {
            for (int j = 0; ; ++j) {
                if (j == n) return i;
                // make sure there will not be indexourofbound
                if (i + j == m) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
    
    /*
    // Time: O(m*n)
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) { return 0; }
        if (haystack == null || haystack.length() == 0) { return -1; }
        
        int m = haystack.length();
        int n = needle.length();
        // 这个判断已经包含在i <= m - n里面
        // if(m < n) return -1;
        // 注意是i <= m - n，否则会有IndexOutOfBoundException
        for (int i = 0; i <= m - n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (haystack.charAt(i+j) != needle.charAt(j)) { break; }
                // 只有当匹配到了最后一个才能返回
                if (j == n - 1) return i;
            }
        }
        return -1;
    }
    */
}