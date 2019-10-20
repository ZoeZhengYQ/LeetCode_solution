class Solution {
    // Binary search
    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length-1;
        while (l < r) {
            int mid = (l + r)/2;
            if (A[mid] < A[mid+1]) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}