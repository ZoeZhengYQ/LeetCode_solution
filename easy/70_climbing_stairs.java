class Solution {
    // DP(i) = DP(i - 1) + DP(i - 2)
    // Fibonacci
    
    public int climbStairs(int n) {
        if (n == 0) return 1;
        int res = 1;
        int s1 = 1;
        int s2 = 1;
        for (int i = 0; i < n - 1; ++i) {
            res = s1 + s2;
            s1 = s2;
            s2 = res;
        }
        return res;
    }
    
    
    // another solution, more elegant
    /* 
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        while (n-- > 0) {
            a = (b += a) - a;
        }
        return a;
    }
    */
    
    // solution using DP
    /*
    public int climbStairs(int n) {
        int[] store = new int[n + 1];
        store[0] = 1;
        store[1] = 1;
        for (int i = 2; i <= n; ++i) {
            store[i] = store[i - 1] + store[i - 2];
        }
        return store[n];   
    }
    */
}