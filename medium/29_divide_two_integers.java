class Solution {
    // Notice that Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE!
    // 注意各种可能overflow的情况！！！
    public int divide(int dividend, int divisor) {
        int sign = (dividend<0) ^ (divisor<0) ? -1 : 1;
        int quotient = 0;
        // Indicate in description that divisor will not be 0
        // if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            if (divisor == Integer.MIN_VALUE) return 1;
            dividend += Math.abs(divisor);
            quotient++;
        }
        if (divisor == Integer.MIN_VALUE) return 0;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int temp = divisor;
            int cnt = 1;
            // Avoid overflow by subtraction!
            while (dividend - temp >= temp) {
                temp <<= 1;
                cnt <<= 1;
            }
            dividend -= temp;
            quotient += cnt;
        }
        return sign < 0 ? -quotient : quotient;
    }
}