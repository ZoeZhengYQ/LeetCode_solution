class Solution {
    // Left and right
    // Use one value to record current status
    // Time: O(n)
    // Space: O(1)
    public int longestMountain(int[] A) {
        int len = A.length;
        if (len < 3) return 0;
        int up = 0, down = 0, res = 0;
        for (int i = 1; i < len; ++i) {
            if (down > 0 && A[i-1]<A[i] || A[i-1] == A[i]) { // start going up
                up = 0;
                down = 0;
            }
            if (A[i-1]<A[i]) up++;
            if (A[i-1]>A[i]) down++;
            if (down > 0 && up > 0) {   // make sure that this is a moutain
                res = Math.max(res, up+down+1);
            }
        }
        return res;
    }
    // Two pointers
    // Time: O(n)
    // Space: O(n)
    /*
    public int longestMountain(int[] A) {
        int len = A.length;
        if (len < 3) return 0;
        int[] left = new int[len];
        int[] right = new int[len];
        
        for (int i = 1; i < len-1; ++i) {
            if (A[i] > A[i-1]) left[i] += left[i-1]+1;
            if (A[len-1-i] > A[len-i]) right[len-1-i] += right[len-i]+1;
        }
         
        int max = 0;
        for (int i = 1; i < len-1; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                int cur = (left[i] + right[i]) > 0 ? (left[i] + right[i] + 1) : 0;
                max = Math.max(cur, max);
            }
        }
        return max;
    }
    */
}