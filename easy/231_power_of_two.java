class Solution {
    // Bit Manipulation
    // Time: O(1) 
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
    // Recursion
    // Time: O(n logn)
    /*
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n == 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }
    */
    
    // Iterative
    // Time: O(n logn)
    /*
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }
    */
    
}