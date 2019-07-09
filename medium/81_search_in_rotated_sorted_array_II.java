class Solution {
    // Binary Search
    // 分区进行BS
    // Time: O(n)
    // Space: O(1)
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            // 为了判断mid的位置，O(n)
            while (l < r && nums[l] == nums[r]) { l++; }
            int mid = (l + r) / 2;
            if (nums[mid] == target) return true;
            // High
            if (nums[mid] >= nums[l]) {
                if (nums[l] <= target && nums[mid] > target) { r = mid-1; }
                else { l = mid+1; }
            }
            // Low
            else { // nums[mid] <= nums[r]
                if (nums[mid] < target && nums[r] >= target) { l = mid+1; }
                else { r = mid-1; }
            }
        }
        return false;
    }
}