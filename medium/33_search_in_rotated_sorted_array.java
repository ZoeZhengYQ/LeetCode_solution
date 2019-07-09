class Solution {
    // Time: O(log n)
    // Space: O(1)
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int rot = findSmallest(nums);
        
        // start & end is the idx of unrotated array
        // realMid is the idx in rotated array
        int start = 0;
        int end = len - 1;
        // use <= because we still need to verify the mid element
        // to see if it equals to target
        while (start <= end) {
            int mid = (start + end) / 2;
            int realMid = (mid + rot) % len;
            if (nums[realMid] == target) return realMid;
            else if (nums[realMid] < target) { start = mid + 1; }
            else { end = mid - 1; }
        }
        return -1;
    }
    
    private int findSmallest(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) { l = mid + 1; }
            else { r = mid; }
        }
        return l;
    }
}