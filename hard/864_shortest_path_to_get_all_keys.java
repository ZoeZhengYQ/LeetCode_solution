class Solution {
    public int shortestPathAllKeys(String[] grid) {
        class State {
            int x;
            int y;
            int keys;
            
            public State(int _keys, int _x, int _y) {
                this.keys = _keys;
                this.x = _x;
                this.y = _y;
            }
            
            @Override
            public String toString() {
                return (keys + " " + x + " " + y);
            }
        }
        
        int row = grid.length;
        int col = grid[0].length();
        
        int x = 0, y = 0;
        int target = 0;
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                
                if (c >= 'a' && c <= 'f') 
                    target |= (1 << (c - 'a'));
            }
        }
        
        // begin BFS
        int steps = 0;
        // left, up, right, down
        int[] disX = new int[]{0, -1, 0, 1};
        int[] disY = new int[]{-1, 0, 1, 0};
        
        Set<String> set = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        
        State start = new State(0, x, y);
        queue.offer(start);
        set.add(start.toString());
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                State cur = queue.poll();
                if (cur.keys == target) return steps;
                for (int i = 0; i < 4; i++) {
                    int newX = cur.x + disX[i];
                    int newY = cur.y + disY[i];
                    int newKeys = cur.keys;
                    if (newX>=0 && newX<row && newY>=0 && newY<col) {
                        char c = grid[newX].charAt(newY);
                        if (c == '#') continue;
                        if (c >= 'a' && c <= 'f') {
                            newKeys |= (1 << (c - 'a'));
                        }
                        if (c >= 'A' && c <= 'F' && ((newKeys & (1 << (c - 'A'))) == 0)) continue;
                        State newState = new State(newKeys, newX, newY);
                        if (set.add(newState.toString())) {
                            queue.offer(newState);
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}