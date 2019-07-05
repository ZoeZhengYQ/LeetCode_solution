class Solution {
    // Permutation遍历的方法：
    // 从小到大一个个slot填充，然后backtracking替换，
    // 最后的结果一定是descending sort
    // 所以找下一个就是要找第一个 n[i-1] < n[i]
    // 然后swap n[i-1] 和后面cloest large的elements
    // 最后reverse sort后半部分即可
    // Time: O(n)
    // Space: O(1)
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) { return; }
        int idx = len - 1;
        while (idx > 0) {
            if (nums[idx-1] < nums[idx]) { break; }
            idx--;
        }
        
        if (idx == 0) {
            reverse(nums, 0, len - 1);
        }
        else {
            int val = nums[idx-1];
            int i = len - 1;
            while (i >= idx) {
                if (nums[i] > val) {
                    break;
                }
                i--;
            }
            swap(nums, i, idx - 1);
            reverse(nums, idx, len - 1);
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
    private void reverse(int[] nums, int x, int y) {
        if (x > y) return;
        int mid = (x + y) / 2;
        for (int i = x; i <= mid; ++i) {
            swap(nums, i, x + y - i);
        }
    }
}