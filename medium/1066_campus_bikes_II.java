class Solution {
    // Bottom-up DFS
    // use a integer to store bike status
    // O (n * 2^m)
    private int minDis = Integer.MAX_VALUE;
    private Map<String, Integer> memo = new HashMap<>();
    public int assignBikes(int[][] workers, int[][] bikes) {
        return helper(workers, bikes, 0, 0);
    }
    
    private int helper(int[][] workers, int[][] bikes, int bikeStatus, int idx) {
        if (idx >= workers.length) return 0;
        
        String str = idx + "," + bikeStatus;
        if (memo.containsKey(str)) return memo.get(str);
        
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; ++i) {
            if ((bikeStatus & (1<<i)) > 0) { continue; }
            dis = Math.min(dis, helper(workers, bikes, bikeStatus|(1<<i), idx+1) + 
                           getDis(workers[idx], bikes[i]));
        }
        memo.put(str, dis);
        return dis;
    }
    
    // Brute Force
    // Top-down DFS
    // Time: O(n * m !) n-># of workers  m ->#of bikes
    /*
    private int minDis = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        // Used bikes
        Set<Integer> used = new HashSet<>();
        helper(workers, bikes, used, 0, 0);
        return minDis;
    }
    
    private void helper(int[][] workers, int[][] bikes, Set<Integer> used, int idx, int dis) {
        if (idx >= workers.length) {
            minDis = Math.min(minDis, dis);
            return;
        }
        if (dis > minDis) return;
        for (int i = 0; i < bikes.length; ++i) {
            if (used.contains(i)) continue;
            
            int newDis = getDis(workers[idx], bikes[i]);
            used.add(i);
            helper(workers, bikes, used, idx+1, dis+newDis);
            used.remove(i);
        }
    }
    */
    
    private int getDis(int[] worker, int[] bike) {
        return Math.abs(worker[0]-bike[0]) + Math.abs(worker[1]-bike[1]);
    }
}