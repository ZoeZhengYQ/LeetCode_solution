class Solution {
    // DP(i) = min(DP(i-1), DP(i-2)) + val(i)
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;
        for (int i = 2; i < cost.length; ++i) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
    
    
    // space complexity could be optimized
    /*
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;
        int[] pay = new int[cost.length];
        pay[0] = cost[0];
        pay[1] = cost[1];
        for (int i = 2; i < pay.length; ++i) {
            pay[i] = Math.min(pay[i - 1], pay[i - 2]) + cost[i];
        }
        return Math.min(pay[pay.length - 1], pay[pay.length - 2]);
    }
    */
}