class Solution {
    // The only thing to care about is to 
    // check if the result exceed max value
    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        x = Math.abs(x);
        int res = 0;
        
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < res || 
                (Integer.MAX_VALUE - x % 10) / 10 < res) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return sign * res;
    }
}