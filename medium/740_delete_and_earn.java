class Solution {
    // 2019-11-4
    // Time: O(1)
    // Space: O(1)
    // if not 1 to 10000, use a map and be aware of overflow
    //  may use mod or long type
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        int[] bucket = new int[10001];
        
        for (int num : nums) { bucket[num]++; }
        
        // 类比 house robber， 有take和skip两种状态，我们就不一定要每次都取max，可以最后再取
        int take = 0, skip = 0;
        for (int i = 1; i <= 10000; ++i) {
            int takeCur = skip + bucket[i] * i;
            int skipCur = Math.max(take, skip);
            take = takeCur;
            skip = skipCur;
        }
        return Math.max(take, skip);
    }

    // DP
    // res[i] = max(take[i], skip[i])
    
    // take[i] = skip[i-1] + value[i]
    // skip[i] = max(take[i-1], skip[i-1])
    /*
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
    */
}