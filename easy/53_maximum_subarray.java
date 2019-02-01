class Solution {
    // DP solution
    
    public int maxSubArray(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int maxHere =  nums[0];
        int maxSub = nums[0];
        for (int i = 1; i < nums.length; ++i){
            maxHere = Math.max(maxHere + nums[i], nums[i]);
            maxSub = Math.max(maxHere, maxSub);
        }
        return maxSub;
    } 
    
}