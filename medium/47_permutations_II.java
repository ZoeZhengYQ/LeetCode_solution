class Solution {
    // Use a set to eliminate duplicates
    // Time: O(n^2)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrace(results, 0, nums);
        return results;
    }
    
    private void backtrace(List<List<Integer>> results, int start, int[] nums) {
        if (start >= nums.length-1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            results.add(list);
            return;
        }
        
        Set<Integer> used = new HashSet<>();
        // 当前数字如果已经被用过作为permute的基准就跳过
        for (int i = start; i < nums.length; ++i) {
            if (used.add(nums[i])) {
                swap(nums, start, i);
                backtrace(results, start + 1, nums);
                swap(nums, start, i);
            }
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        if (x >= nums.length || y >= nums.length || x == y) 
            return;
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
