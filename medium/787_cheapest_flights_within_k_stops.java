class Solution {
    // Dijkstra's Algorithm
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            if (!graph.containsKey(f[0])) {
                graph.put(f[0], new ArrayList<>());
            }
            // Map<from, List<int[to, cost]>>
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }
        
        PriorityQueue<City> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new City(src, 0, K + 1));
        
        while (!pq.isEmpty()) {
            City cur = pq.poll();
            if (cur.id == dst) return cur.cost;
            if (cur.stopCnt <= 0 || !graph.containsKey(cur.id)) { continue; }
            for (int[] edge : graph.get(cur.id)) {
                pq.offer(new City(edge[0], cur.cost+edge[1], cur.stopCnt-1));
            }
        }
        return -1;
    }
    
    class City {
        int id, cost, stopCnt;
        
        City(int id, int cost, int stopCnt) {
            this.id = id;
            this.cost = cost;
            this.stopCnt = stopCnt;
        }
    }
}
