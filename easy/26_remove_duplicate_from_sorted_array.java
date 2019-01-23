class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int cnt = 0;
        int curVal = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == curVal) { cnt++; }
            else {
                curVal = nums[i];
                nums[i - cnt] = nums[i];
            }
        }
        return nums.length - cnt;
    }
}