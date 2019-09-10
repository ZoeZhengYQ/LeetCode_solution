class Solution {
    // Greedy, but sort start and end seperately
    // Time: O(2n log2n)
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        if (len <=1) return len;
        
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; ++i) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms = 0;
        int endIdx = 0;
        for (int s : start) {
            if (s < end[endIdx])
                rooms++;
            else
                endIdx++;
        }
        return rooms;
    }
    
    // TreeMap: Record max active room number
    // Time: O(nlogn)
    // Space: O(2n)
    /*
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        if (len <=1) return len;
        
        // Order with ascending order of key
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; ++i) {
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0], 0) + 1);
            map.put(intervals[i][1], map.getOrDefault(intervals[i][1], 0) - 1);
        }
        
        int max = 0, cur = 0;
        // Current keep track of active rooms at a particular time
        for (int i : map.keySet()) {
            max = Math.max(max, cur += map.get(i));
        }
        return max;
    }
    */
    
    // Greedy: Sort and min-heap to track minimum end time
    // Time: O(n logn) + O(logn)
    // Space: O(n)
    /*
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        if (len <=1) return len;
        
        // Sort intervals with ascending order of start time
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        // Use min heap to track the min-end time
        // Like merge intervals
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[1], b[1]);
        });
        pq.offer(intervals[0]);
        for (int i = 1; i < len; ++i) {
            int[] top = pq.peek();
            if (top[1] > intervals[i][0]) {
                pq.offer(intervals[i]);
            } else {
                int[] temp = pq.poll();
                pq.offer(new int[]{temp[0], intervals[i][1]});
            }
        }
        return pq.size();
    }
    */
}