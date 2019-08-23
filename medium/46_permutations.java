class Solution {
    // Recursive backtrace
    // Time: O(n^2)
    // Space: O(n^2)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrace(results, 0, nums);
        return results;
    }
    
    private void backtrace(List<List<Integer>> results, int start, int[] nums) {
        // Return when start hit the last element in array
        // Because what you would do is swap it with itself
        if (start >= nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            results.add(list);
            return;
        }
        
        for (int i = start; i < nums.length; ++i) {
            swap(nums, start, i);
            backtrace(results, start+1, nums);
            swap(nums, start, i);
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        if (x >= nums.length || y >= nums.length || x == y) {
            return;
        }
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}