class Solution {
    public boolean isPowerOfFour(int num) {
        // num & 0x55555555 helps get rid of those is power of 2 but not power of 4
        return num > 0 && (num & (num-1)) == 0 && (num & 0x55555555) != 0;
    }
}