class Solution {
    // BFS: key: use a boolean and a node to represent the snake status
    //  Use a string as key to the hashset
    public int minimumMoves(int[][] grid) {
        int xLen = grid.length, yLen = grid[0].length;
        Set<String> visited = new HashSet<>();
        Queue<Snake> q = new LinkedList<>();
        Snake init = new Snake(0, 0, true);
        
        int steps = 0;
        q.add(init);
        visited.add(init.toString());
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Snake cur = q.remove();
                int x = cur.tail[0];
                int y = cur.tail[1];
                if (x == xLen-1 && y == yLen-2 && cur.isHor == true) {
                    return steps;
                }
                if (cur.isHor) { // Horizontal
                    if (x+1 < xLen && y+1 < yLen && grid[x+1][y] == 0 && grid[x+1][y+1] == 0) {
                        // clockwise
                        Snake cw = new Snake(x, y, false);
                        if (!visited.contains(cw.toString())) {
                            q.add(cw);   
                            visited.add(cw.toString());
                        }
                        // Snake down
                        Snake down = new Snake(x+1, y, true);
                        if (!visited.contains(down.toString())) {
                            q.add(down);   
                            visited.add(down.toString());
                        }
                    }
                    if (y+2 < yLen && grid[x][y+2] == 0) {
                        // right
                        Snake right = new Snake(x, y+1, true);
                        if (!visited.contains(right.toString())) {
                            q.add(right);   
                            visited.add(right.toString());
                        }
                    }
                } else {    // Vertical
                    if (x+1 < xLen && y+1 < yLen && grid[x][y+1] == 0 && grid[x+1][y+1] == 0) {
                        // counterclockwise
                        Snake ccw = new Snake(x, y, true);
                        if (!visited.contains(ccw.toString())) {
                            q.add(ccw);   
                            visited.add(ccw.toString());
                        }
                        // right
                        Snake right = new Snake(x, y+1, false);
                        if (!visited.contains(right.toString())) {
                            q.add(right);   
                            visited.add(right.toString());
                        }
                    }
                    if (x+2 < xLen && grid[x+2][y] == 0) {
                        // Down
                        Snake down = new Snake(x+1, y, false);
                        if (!visited.contains(down.toString())) {
                            q.add(down);   
                            visited.add(down.toString());
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    class Snake {
        int[] tail;
        boolean isHor;
        
        Snake(int x, int y, boolean isHor) {
            this.tail = new int[]{x, y};
            this.isHor = isHor;
        }
        
        @Override
        public String toString(){
            return "(" + tail[0] +","+ tail[1] + ")" + isHor;
        }
    }
}