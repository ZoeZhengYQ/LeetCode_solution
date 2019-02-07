class Solution {
    // binary search 
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            if (nums[start] < nums[end]) 
                return nums[start];
            
            int mid = (start + end) / 2;
            
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}