class Solution {
    // Topological Sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int res = 0;
        int[] preCnt = new int[numCourses];
        
        for (int[] pair : prerequisites) {
            preCnt[pair[0]]++;   
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (preCnt[i] == 0) {
                q.offer(i);   
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            res++;
            for (int[] pair : prerequisites) {
                if (pair[1] == cur) {
                    preCnt[pair[0]]--;
                    if (preCnt[pair[0]] == 0) {
                        q.offer(pair[0]);
                    }
                }
            }
        }
        return res == numCourses;
    }
}