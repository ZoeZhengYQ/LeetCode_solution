class Solution {
    // Union find
    // Time: O(N^2)
    // Space: O(N)
    private Map<String, String> parents = new HashMap<>();
    private int islandNum;
    
    public int removeStones(int[][] stones) {
        // Initialize
        islandNum = stones.length;
        for (int[] stone : stones) {
            String str = stoneIdxStr(stone);
            parents.put(str, str);
        }
        
        for (int[] stone1 : stones) {
            String str1 = stoneIdxStr(stone1);
            for (int[] stone2 : stones) {
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    String str2 = stoneIdxStr(stone2);
                    union(str1, str2);
                }
            }
        }
        return stones.length - islandNum;
    }
    
    private void union(String s1, String s2) {
        String p1 = find(s1);
        String p2 = find(s2);
        
        if (p1.equals(p2)) {
            return;
        }
        parents.put(p1, p2);
        islandNum--;
    }
    
    private String find(String s) {
        String curP = parents.get(s);
        if (!curP.equals(s)) {
            parents.put(s, find(curP));
        }
        return parents.get(s);
    }
    
    private String stoneIdxStr(int[] stone) {
        return stone[0] + " " + stone[1];
    }
    // Connected stone: stone with same row or col
    // DFS find island
    // Time: O(N^2)
    // Space: O(N)
    /*
    private Set<int[]> visited = new HashSet<>();
    private int islandNum = 0;
    
    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                dfs(stones, stone);
                islandNum++;
            }
        }
        return stones.length - islandNum;
    }
    
    private void dfs(int[][] stones, int[] stone) {
        this.visited.add(stone);
        for (int[] anotherStone : stones) {
            if (!visited.contains(anotherStone)) {
                if (stone[0] == anotherStone[0] || stone[1] == anotherStone[1]) {
                    dfs(stones, anotherStone);
                }
            }
        }
    }
    */
}