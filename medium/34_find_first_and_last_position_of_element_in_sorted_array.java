class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int l = 0, r = nums.length-1;
        // Search for left one
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target || 
                       (mid > 0 && nums[mid-1] == target)) {
                r = mid - 1;
            } else {
                res[0] = mid;
                break;
            }
        }
        if (res[0] == -1) return res;
        
        // Search for right one
        l = 0;
        r = nums.length-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target || 
                (mid < nums.length-1 && nums[mid+1] == target)) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                res[1] = mid;
                break;
            }
        }
        return res;
    }
}