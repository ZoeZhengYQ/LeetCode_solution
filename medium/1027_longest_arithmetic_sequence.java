class Solution {
    // DP
    // dp[i]: i is the idx of element in array
    // use a hashmap array, where a hashmap records 
    // all seen diff from previous element to current element
    public int longestArithSeqLength(int[] A) {
        int len = A.length;
        if (len <= 2) return len;
        
        int max = 0;
        Map<Integer, Integer>[] dp = new HashMap[len];
        
        for (int i = 0; i < len; ++i) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                int diff = A[i]-A[j];
                // add previously seen result if any
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                // update max value
                max = Math.max(max, dp[i].get(diff));
            }
        }
        return max;
    }
}