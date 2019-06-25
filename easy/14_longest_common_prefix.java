class Solution {
    // Make use of indexOf()
    // Time: O(kn)
    
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) { return ""; }
        if (len == 1) { return strs[0]; }
        String prefix = strs[0];
        for (int i = 1; i < len; ++i) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
    
    
    /*
    // Naive method to vertically compare
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        boolean flg = false;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].length()-1 < i || strs[j].charAt(i) != c) {
                    flg = true;
                    break;
                }
                if (strs[j].charAt(i) == c && j == strs.length-1) {
                    res.append(c);
                }
            }   
            if (flg) {
                break;
            }
        }
        return res.toString();
    }
    */
}