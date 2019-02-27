class Solution {
    
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = Arrays.deepToString(board).replaceAll("(\\[)|(\\])|,|\\s+", "");
        
        int row = board.length;     // 2
        int col = board[0].length;  // 3
        
        final int[] dis = new int[]{-1, 1, -col, col};
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);
        int res = 0;
        
        while (!queue.isEmpty()) {
            for (int s = queue.size(); s > 0; --s) {
                String cur = queue.poll();
                System.out.println(cur);
                if (cur.equals(target)) return res;
                int idx = cur.indexOf('0');
                for (int i = 0; i < dis.length; ++i) {
                    int d = dis[i];
                    if ((idx % col == (col-1) && d == 1) || 
                        (idx % col == 0 && d == -1) || 
                        (idx + d < 0) || 
                        (idx + d >= row * col)) 
                        continue;
                    String states = swap(cur, idx, idx + d);
                    if (visited.add(states)) {
                        queue.offer(states);
                    }
                }
            }
            res++;
        }
        return -1;
        
    }
    
    private String swap(String str, int x, int y) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(x, str.charAt(y));
        sb.setCharAt(y, str.charAt(x));
        return sb.toString();
    }
}