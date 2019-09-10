class Solution {
    // Sorting with the start time
    // Time: O(n logn)
    // Space: O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) return true;
        // Sort in ascending order of start time
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int curMax = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i-1][1] > intervals[i][0]) 
                return false;
        }
        return true;
    }
}