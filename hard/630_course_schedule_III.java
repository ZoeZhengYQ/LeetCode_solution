class Solution {
    // Greedy
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1]-b[1]); // Sort by earliest end time
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.offer(course[0]);
            // If do not fit, remove the longest course that previously taken
            // Note that it is impossible that after we remove a course, the space would allow a 
            // previous missed course to fit
            // Because any courses we missed would be longer than what's in priority queue. 
            if (time > course[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}
