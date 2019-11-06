class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        
        int r = len - 1;
        while (r > 0) {
            if (checkPal(s, r)) { break; }
            r--;
        }
        
        String add = s.substring(r+1, len);
        StringBuilder sb = new StringBuilder();
        for (int i = add.length()-1; i >= 0; --i) {
            sb.append(add.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
    
    private boolean checkPal(String s, int r) {
        int tl = 0, tr = r;
        while (tl < tr) {
            if (s.charAt(tl) != s.charAt(tr)) {
                return false;
            }
            tl++;
            tr--;
        }
        return true;
    }
}