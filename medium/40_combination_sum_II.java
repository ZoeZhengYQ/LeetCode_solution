class Solution {
    // Backtracking: DFS
    // Time: O(2^n)
    // Space: O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtrack(results, list, 0, candidates, target);
        return results;
    }
    
    private void backtrack(List<List<Integer>> results, List<Integer> list, int start, int[] candidates, int target) {
        // check value of target first
        // or you would not add results that include the last elements
        if (target == 0) {
            results.add(new ArrayList<>(list));
        }
        if (start >= candidates.length || target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            // skip duplicates
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(results, list, i+1, candidates, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}