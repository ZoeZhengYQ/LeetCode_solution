class Solution {
    // DP
    // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    // Time: O(n)
    // Space: O(n)
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }
    
    // Top-down dfs w/ memo
    /*
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] memo = new int[len];
        Arrays.fill(memo, -1);
        return helper(nums, memo, len-1);
    }
    
    private int helper(int[] nums, int[] memo, int idx) {
        if (idx < 0) {
            return 0;
        }
        if (memo[idx] >= 0) {
            return memo[idx];
        }
        int result = Math.max((helper(nums, memo, idx-2) + nums[idx]), helper(nums, memo, idx-1));
        memo[idx] = result;
        return result;
    }
    */
    
    // Naive solution, hard to add memo, TLE
    /*
    private int max = 0;
    public int rob(int[] nums) {
        helper(nums, 0, 0);
        return max;
    }
    
    private void helper(int[] nums, int start, int sum) {
        if (start >= nums.length) {
            max = Math.max(sum, max);
            return;
        }
        
        if (start < nums.length-1) { // can rob start + 1
            helper(nums, start+3, sum+nums[start+1]);
        }
        // rob start
        helper(nums, start+2, sum+nums[start]);
    }
    */
}