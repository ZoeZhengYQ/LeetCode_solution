class Solution {
    // Backtrace to list all the subsets
    // Time: O(2^n) 每个数字都有在不在subset内的选择
    // Space: O(n^2)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrace(results, subset, nums, 0);
        return results;
    }
    
    private void backtrace(List<List<Integer>>results, List<Integer> subset, int[] nums, int startIdx) {
        results.add(new ArrayList<>(subset));
        for (int i = startIdx; i < nums.length; ++i) {
            subset.add(nums[i]);
            backtrace(results, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}