class Solution {
    // 每次都加n-1个1，相当于每次减一个1
    // Time: O(n)
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int minVal = nums[0];
        
        for (int num : nums) {
            sum += num;
            if (num < minVal) { minVal = num; }
        }
        
        return (sum - nums.length * minVal);
    }
    
    // because of the sort, Time: O(n logn)
    /*
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int base = nums[0];
        for (int i = nums.length - 1; i > 0; --i) {
            count += (nums[i] - base);
        }
        return count;
    }
    */
}