class Solution {
    // DFS solution (recursion)
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int size = M.length;
        int count = 0;
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; ++i) {
            if (visited[i] == false) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] M, boolean[] visited, int idx) {
        int len = M.length;
        for (int i = 0; i < len; ++i) {
            if (i == idx) continue;
            if (M[idx][i] == 1 && visited[i] == false) {    // dont forget visited == false!!
                visited[i] = true;
                dfs(M, visited, i);
            }
        }
    }
    // solution using BFS
    // 6ms, 72.52%
    // Time: O(n^2)
    // Space: O(n)
    /* could use DFS to save space! */
    /*
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        
        int size = M.length;
        int count = 0;
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < size; ++i) {
            if (visited[i] == true) continue;
            queue.add(i);
            visited[i] = true;
            count++;
            while (!queue.isEmpty()) {
                int cur = queue.remove();
                for (int j = 0; j < size; ++j) {
                    if (j == cur || visited[j] == true) continue;
                    if (M[cur][j] == 1) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }
        return count;
    }
    */
}