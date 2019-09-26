class Solution {
    // BFS
    // Only add the course if ALL prerequisites are fulfilled!!
    // Time: O(nm) n-># of course (nodes), m-> prerequisites pair length (edges)
    // Space: O(n)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        int idx = 0;
        int[] preCnt = new int[numCourses];
        int[] res = new int[numCourses];
        LinkedList<Integer> q = new LinkedList<>();
        
        for (int[] pair : prerequisites) {
            preCnt[pair[0]]++;
        }
        
        for (int i = 0; i < numCourses; ++i) {
            if (preCnt[i] == 0) {
                res[idx++] = i;
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int preC = q.poll();
            for (int[] pair : prerequisites) {
                if (pair[1] == preC) {
                    preCnt[pair[0]]--;
                    if (preCnt[pair[0]] == 0) {
                        res[idx++] = pair[0];
                        q.offer(pair[0]);
                    }
                }
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}