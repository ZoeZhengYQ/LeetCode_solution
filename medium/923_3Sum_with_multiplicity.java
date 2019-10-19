class Solution {
    // Count and loop, because number have range
    // Time: O(n * 101 * 101)
    // Space: O(101)
    
    public int threeSumMulti(int[] A, int target) {
        if (A.length == 0) return 0;
        long[] cnt = new long[101];
        for (int i : A) {
            cnt[i]++;
        }
        
        long res = 0;
        for (int i = 0; i < 101; ++i) {
            for (int j = i; j < 101; ++j) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k) { // 三个都相等
                    res += (cnt[i]*(cnt[i]-1)*(cnt[i]-2)) / 6;
                } else if (i == j && j != k) {  // 两个相等
                    res += (cnt[i] * (cnt[i]-1)) / 2 * cnt[k];
                } else if (j < k) { // 三个不等，此时i<j<k可以避免重复
                    res += cnt[i] * cnt[j] * cnt[k];
                }
            }
        }
        return (int) (res % 1000000007);
    }
    
    
    // Time: O(n^2)
    // Space: O(n^2)
    // 为了避免重复使用一个值， 先算没有A[i]的res，然后再把含有A[i]的sumCnt加入map
    /*
    public int threeSumMulti(int[] A, int target) {
        if (A.length == 0) return 0;
        long res = 0;
        Map<Integer, Integer> cntSum = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            int k = target - A[i];
            res += cntSum.getOrDefault(k, 0);
            for (int j = 0; j < i; ++j) {
                int sum = A[i] + A[j];
                cntSum.put(sum, cntSum.getOrDefault(sum, 0) + 1);
            }
        }
        return (int) (res % 1000000007);
        
    }
    */
}