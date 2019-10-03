class Solution {
    // Tarjan algorithm to find critical connextions
    private int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] low = new int[n];  // the lowest vertex u can reach
        int[] disc = new int[n]; // discover time of vertex
        Arrays.fill(disc, -1); // If not visited, disc[i] == -1
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] G = new ArrayList[n]; // Adjacency List
        
        for (int i = 0; i < n; ++i) {
            G[i] = new ArrayList<>();
        }
        
        for (List<Integer> c : connections) {
            G[c.get(0)].add(c.get(1));
            G[c.get(1)].add(c.get(0));
        }
        
        for (int i = 0; i < n; ++i) {
            if (disc[i] == -1) {
                dfs(i, i, low, disc, res, G);
            }
        }
        return res;
    }
    
    private void dfs(int pre, int u, int[] low, int[] disc, List<List<Integer>> res, List<Integer>[] G) {
        low[u] = disc[u] = ++time;  // mark discovered
        for (int v : G[u]) {
            if (v == pre) { continue; } // Exclude parent
            if (disc[v] == -1) { // not visited
                dfs(u, v, low, disc, res, G);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {  // v cannot access node lower than u, note this is not >=!!
                    res.add(Arrays.asList(u, v));
                }
            } else { // visited, then v is not in u's subtree
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}