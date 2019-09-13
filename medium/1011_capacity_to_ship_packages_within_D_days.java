class Solution {
    // Binary Search: To find a min partition sum of an array
    // Split array large sum
    // Time: O(n) + O(n log(sum-max))
    // Space: O(1)
    public int shipWithinDays(int[] weights, int D) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < weights.length; ++i) {
            low = Math.max(low, weights[i]);
            if (i <= weights.length-D) {
                high += weights[i];
            }
        }
        
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 1;
            int curW = 0;
            for (int i = 0; i < weights.length; ++i) {
                if (curW + weights[i] <= mid) {
                    curW += weights[i];
                } else {
                    curW = weights[i];
                    count++;
                }
                if (count > D) {
                    low = mid + 1;
                } else if (i == weights.length-1) {
                    high = mid;
                }
            }
        }
        return low;
    }
}