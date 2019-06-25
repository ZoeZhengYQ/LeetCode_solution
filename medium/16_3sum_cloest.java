class Solution {
    // Three ptrs
    // Time: O(n^2)
    // Space: O(1)
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) return Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        // 不能设置为Integer.MAX_VALUE因为有可能会overflow
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < len-2; ++i) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}