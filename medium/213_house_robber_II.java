class Solution {
    // 3 cases:
    // 1) rob 1st house, not rob last house
    // 2) rob last house, not rob 1st house
    // 3) not rob both
    // result = max(rob 0 to len-2, rob 1 to len-1)
    // Time: O(n)
    // Space: O(1)
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    
    private int helper(int[] nums, int start, int end) {
        int rob = 0, notRob = 0;
        for (int i = start; i <= end; ++i) {
            int tmpRob = rob + nums[i];
            int tmpNotRob = notRob;
            rob = notRob;
            notRob = Math.max(tmpRob, tmpNotRob);
        }
        return Math.max(rob, notRob);
    }
}