class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(left+1, right, s) || isPalindrome(left, right-1, s);
            }
        }
        return true;
    }
    
    private boolean isPalindrome(int left, int right, String str) {
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}