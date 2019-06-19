class Solution {
    // Create numRows of StringBuilder and append
    // by the order of zigzag
    // Time: O(n)
    // Sapce: O(n)
    public String convert(String s, int numRows) {
        if (numRows == 0) { return ""; }
        if (numRows == 1) { return s; }
        
        int len = s.length();
        char[] charArr = s.toCharArray();
        StringBuilder[] list = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            list[i] = new StringBuilder();
        }
        
        int i = 0;
        int idx = 0;
        while (i < len) {
            while (i < len && idx < numRows-1) {
                list[idx].append(charArr[i]);
                idx++;
                i++;
            }
            while (i < len && idx > 0) {
                list[idx].append(charArr[i]);
                idx--;
                i++;
            }
        }
        for (int j = 1; j < numRows; ++j) {
            list[0].append(list[j].toString());
        }
        return list[0].toString();
    }
}