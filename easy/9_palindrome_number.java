class Solution {
    public boolean isPalindrome(int x) {
        String str = ((Integer)x).toString();
        int i = 0;
        int j = str.length() - 1;
        for ( ; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}