class Solution {
    // Follow up O(n logn)
    // Binary search, patience sort
    // 维护一个array，内容是当前长度的所有IS尾巴的最小值
    // Tail是递增的，所以可以用BS
    // Time: O(n logn)
    // Space: O(n)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        
        int size = 0;
        int[] tail = new int[len];
        for (int num : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i+j)/2;
                if (tail[m] < num) {
                    i = m+1;
                } else {
                    // Eliminate the case where tail[m] == num
                    // No duplicate in the given array
                    j = m;
                }
            }
            // Replace the possible longest subarray's tail with current one
            tail[i] = num;
            // If num is larger than all tails, increase the size(append it)
            // 如果num是最大的，BS最后会落在i == size的为止，此时tail[size]还是预先的0
            if (i == size) size++;
        }
        return size;
    }
    // DP dynamic programming
    // DP can avoid overlapping calculation in DFS
    // Time: O(n^2)
    // Space: O(n)
    /*
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        
        int[] res = new int[len];
        Arrays.fill(res, 1);
        // Pointer to current position for udpate
        for (int i = 1; i < len; ++i) {
            // Pointer to current position for compare
            for (int j = 0; j < i; ++j) {
                // This means nums[i] could contribute to the subarray
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j]+1);
                }
            }
        }
        
        int max = 0;
        for (int k = 0; k < len; ++k) {
            max = Math.max(res[k], max);
        }
        return max;
    }
    */
}