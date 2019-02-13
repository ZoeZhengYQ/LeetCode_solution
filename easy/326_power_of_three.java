class Solution {
    // Time: O(1)
    // this method only works for prime base
    public boolean isPowerOfThree(int n) {
        // maxPowerOfThree = 1162261467 = 3^19; 
        // 3^20 is bigger than int
        return n > 0 && (1162261467 % n == 0);
    }
    /*
    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n == 0 || n % 3 != 0) return false; 
        return isPowerOfThree(n / 3);
    }
    */
}