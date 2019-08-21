class Solution {
    // Backtrace
    // Note that we should skip duplications
    // Time: O(2^n)
    // Space: O(n^2)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrace(results, subset, nums, 0);
        return results;
    }
    
    private void backtrace(List<List<Integer>> results, List<Integer> subset, int[] nums, int start) {
        results.add(new ArrayList<>(subset));
        for (int ele : subset) {
            System.out.print(ele + " ");    
        }
        System.out.println(" ");
        if (nums.length == 0) return;
        for (int i = start; i < nums.length; ++i) {
            // To skip duplication
            // E.g. [1, 2, 2], subset as [1, 2] where the 2 could 
            //  be the first or the second one
            if (i > start && nums[i-1] == nums[i]) continue;
            subset.add(nums[i]);
            backtrace(results, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}