class Solution {
    // DP
    // res[i] = max(take[i], skip[i])
    
    // take[i] = skip[i-1] + value[i]
    // skip[i] = max(take[i-1], skip[i-1])
    public int deleteAndEarn(int[] nums) {
        // nums range[1, 10000]
        
        int[] bucket = new int[10001];
        
        for (int num : nums) {
            bucket[num] += num;
        }
        
        // record previous status
        int take = 0;
        int skip = 0;
        for (int i = 1; i < 10001; ++i) {
            int takei = skip + bucket[i];
            int skipi = Math.max(take, skip);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
}