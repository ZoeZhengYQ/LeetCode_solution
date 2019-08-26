class Solution {
    // 思考：有没有负数有没有0？
    // Backtrace: DFS
    // Time: O(2^n)
    // Space: O(n) list copying
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrace(results, list, 0, candidates, target);
        return results;
    }
    
    private void backtrace(List<List<Integer>> results, List<Integer> list, int start, int[] candidates, int target) {
        if (target < 0) { return; }
        if (target == 0) {
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            list.add(candidates[i]);
            backtrace(results, list, i, candidates, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}