class Solution {
    // Time: O(n logn) + O(n)
    // Space: O(1)
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        // Sort in ascending order of the first element
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] curInterval = intervals[0];
        for (int[] interval : intervals) {
            // Overlap
            if (curInterval[1] >= interval[0]) {
                curInterval[1] = Math.max(curInterval[1], interval[1]);
            } else {
                result.add(curInterval);
                curInterval = interval;
            }
        }
        // Remember to add the last one
        result.add(curInterval);
        // new int[0][] inside, or you would get a Object[]
        return result.toArray(new int[0][]);
    }
}