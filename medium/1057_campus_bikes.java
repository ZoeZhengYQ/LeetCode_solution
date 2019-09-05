class Solution {
    // min-heap solution
    // Time: O(mn)
    // Space: O(mn)
    // another solution: Bucket Sort (distance range[0, 2000])
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Set<Integer> bikeUsed = new HashSet<>();
        
        // Sort the pair by ascending order of Distance, workerIdx, bikeIdx
        PriorityQueue <int[]> pq = new PriorityQueue<>((p1, p2) -> {
            int compDis = p1[0] - p2[0];
            int compWIdx = p1[1] - p2[1];
            int compBIdx = p1[2] - p2[2];
            return compDis==0 ? (compWIdx==0 ? compBIdx : compWIdx) : compDis;
        });
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int curDis = manDis(workers[i], bikes[j]);
                pq.add(new int[]{curDis, i, j});
            }
        }
        
        while (bikeUsed.size() < n) {
            int[] curPair = pq.poll();
            if (bikeUsed.contains(curPair[2])) continue;
            if (res[curPair[1]] != -1) continue;
            res[curPair[1]] = curPair[2];
            bikeUsed.add(curPair[2]);
        }
        
        return res;
    }
    
    private int manDis(int[] workerCood, int[] bikeCood) {
        return Math.abs(workerCood[0] - bikeCood[0]) + 
               Math.abs(workerCood[1] - bikeCood[1]);
    }
}