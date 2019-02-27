class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        
        int h = costs.length;
        int c = costs[0].length;
        
        if (c == 1) return (h == 1)? costs[0][0] : -1;
        
        // initialize pre state
        int preMinIdx = -1, preMin = Integer.MAX_VALUE, preSecMin = Integer.MAX_VALUE;
        for (int j = 0; j < c; ++j) {
            if (costs[0][j] < preMin) {
                preSecMin = preMin;
                preMin = costs[0][j];
                preMinIdx = j;
            } else if (costs[0][j] < preSecMin) {
                preSecMin = costs[0][j];
            }
        }
        
        // skip first house
        for (int i = 1; i < h; ++i) {
            int minIdx = -1, min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
            for (int j = 0; j < c; ++j) {
                int val = costs[i][j] + ((j == preMinIdx) ? preSecMin : preMin);
                
                if (val < min) {
                    secMin = min;
                    min = val;
                    minIdx = j;
                } else if (val < secMin) {
                    secMin = val;
                }
            }
            
            preMinIdx = minIdx;
            preMin = min;
            preSecMin = secMin;
        }
        return preMin;
    }
}