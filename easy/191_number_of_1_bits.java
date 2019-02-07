public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // int should be 32 bits
        int cnt = 0;
        for (int i = 0; i < 32; ++i) { 
            if (((n >> i) & 1) == 1) {
               cnt++; 
            }
        }
        return cnt;
    }
}