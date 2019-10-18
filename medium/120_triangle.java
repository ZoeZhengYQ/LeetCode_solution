class Solution {
    // DP
    // Time: O(n^2)
    // Space: O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = triangle.get(n-1).get(i);
        }
        
        for (int level = n-2; level >= 0; --level) {
            for (int i = 0; i <= level; ++i) {
                res[i] = Math.min(res[i], res[i+1]) + triangle.get(level).get(i);
            }
        }
        return res[0];
    }
}