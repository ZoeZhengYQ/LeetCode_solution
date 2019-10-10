class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int len = cells.length;
        if (len <= 2) return new int[len];
        Map<String, Integer> map = new HashMap<>();
        
        while (N > 0) {
            map.put(Arrays.toString(cells), N);
            N--;
            int[] next = new int[len];
            for (int i = 1; i < len-1; ++i) {
                next[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
            }
            cells = next;
            if (map.containsKey(Arrays.toString(cells))) { // Loop
                // Use mod to find the minimum steps needed to get to result
                N %= (map.get(Arrays.toString(cells)) - N);
            }
        }
        return cells;
    }
}