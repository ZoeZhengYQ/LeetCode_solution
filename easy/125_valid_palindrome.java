class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        if (str == null || str.length() < 2) return true;
        int i = 0;
        int j = str.length() - 1;
        for (; i < j; ++i, --j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }
}