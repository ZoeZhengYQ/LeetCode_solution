class Solution {
    // DP
    // F(i,n): i as root, n number in total
    // F(i,n) = G(i-1) * G(n-i)
    // G(n) = F(1,n) + F(2,n) + ...+ F(n,n)
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        
        for (int i = 2; i <= n; ++i) {
            for (int root = 1; root <= i; ++root) {
                G[i] += (G[root-1] * G[i-root]);
            }
        }
        return G[n];
    }
}