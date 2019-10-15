class Solution {
    // Time: O(n)
    // Space: O(1)
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int left = 0;
        int right = sum;
        for (int i = 0; i < nums.length; ++i) {
            left += (i < 1 ? 0 : nums[i-1]);
            right -= nums[i];
            if (left == right) return i;
        }
        return -1;
    }
}