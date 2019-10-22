class Solution {
    // Time: O(n)
    public boolean isOneBitCharacter(int[] bits) {
        int cnt = 0;
        for (int i = bits.length - 2; i >= 0 && bits[i] == 1; --i) {
            cnt++;
        }
        // if sequential 1 is odd, then they are not able to pair (one of them would left)
        // if even 1, return true
        return cnt % 2 == 0;
    }
    /*
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            if (bits[i] == 0) i++;
            else i+= 2;
        }
        return i == n-1;
    }
    */
}