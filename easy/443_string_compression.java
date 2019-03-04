class Solution {
    public int compress(char[] chars) {
        int res = 0;
        int idx = 0;
        int count = 0;
        int len = chars.length;
        
        while (idx < len) {
            char cur = chars[idx];
            count = 0;
            while (idx < len && chars[idx] == cur) {
                idx++;
                count++;
            }
            
            chars[res++] = cur;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }
        return res;
    }
}