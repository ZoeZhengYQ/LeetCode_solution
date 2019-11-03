class Solution {
    // One pass BS
    // Time: O(logn)
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l+(r-l)/2;
            if (nums[m] == target) return m;
            
            if (nums[l] <= nums[m]) { // left part sorted
                if (target < nums[m] && target >= nums[l]) { // in left part
                    r = m-1;
                } else {
                    l = m+1;
                }
            }
            
            if (nums[m] <= nums[r]) { // right part sorted
                if (target > nums[m] && target <= nums[r]) { // in right part
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }
        return -1;  // not found
    }
    
    /*
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
    */
}