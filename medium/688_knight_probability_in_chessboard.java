class Solution {
    // DP
    // Time: O(N^2*K)
    // Space: O(N^2)
    private int[] rDis = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
    private int[] cDis = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
    
    public double knightProbability(int N, int K, int r, int c) {
        double[][] cur = new double[N][N];
        double[][] pre = new double[N][N];
        
        for (double[] row : pre) {
            Arrays.fill(row, 1.0);
        }
        
        for (int k = 0; k < K; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    cur[i][j] = 0.0;
                    for (int m = 0; m < 8; ++m) {
                        int x = i + rDis[m], y = j + cDis[m];
                        if (x < 0 || x >= N || y < 0 || y >= N) { continue; }
                        cur[i][j] += 0.125 * pre[x][y];
                    }
                }
            }
            // Remember to swap, not just cur = pre!
            double[][] tmp = cur;
            cur = pre;
            pre = tmp;
        }
        return pre[r][c];
    }
    
    // DFS with memo
    /*
    private int[] rDis = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
    private int[] cDis = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
    private Map<String, Double> memo = new HashMap<>();
    
    public double knightProbability(int N, int K, int r, int c) {
        return helper(r, c, N, K);
    }
    
    private double helper(int r, int c, int N, int k) {
        String str = r + "," + c + "," + k;
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        if (k < 0) { return 1.0; }
        if (r < 0 || r >= N || c < 0 || c >= N) { // Out of bound
            return 0.0;
        }
        
        double res = 0.0;
        for (int i = 0; i < 8; ++i) {
            res += 0.125 * helper(r+rDis[i], c+cDis[i], N, k-1);
        }
        memo.put(str, res);
        return res;
    }
    */
}