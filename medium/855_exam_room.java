class ExamRoom {
    PriorityQueue<Interval> pq;
    Map<Integer, int[]> map;    // value[0] is pre seat that have used, value[1] is next seat that have used
    int N;  

    class Interval {
        int x, y, dist;
        public Interval(int x, int y) {
            this.x = x;
            this.y = y;
            if (x == -1) {
                this.dist = y;
            } else if (y == N) {
                this.dist = N - 1 - x;
            } else {
                // divided by 2 to eliminate case where interval cannot be evenly divided 
                this.dist = Math.abs(x - y)/2;   
            }
        }
        
        @Override
        public String toString() {
            return "[" + x + "," + y + "," + dist + "]";
        }
    }

    public ExamRoom(int N) {
        this.pq = new PriorityQueue<>((a, b) -> a.dist != b.dist? b.dist - a.dist : a.x - b.x);
        this.N = N;
        this.map = new HashMap<>();
        pq.add(new Interval(-1, N));
        map.put(-1, new int[]{-1, N});
        map.put(N, new int[]{-1, N});
    }

    // O(logn): poll top candidate, split into two new intervals
    public int seat() {
        Interval itv = pq.poll();
        if (!map.containsKey(itv.x) || !map.containsKey(itv.y) || itv.dist <= 0) {
            return this.seat();   
        }
        int seat = 0;
        if (itv.x == -1) seat = 0;
        else if (itv.y == N) seat = N - 1;
        else seat = (itv.x + itv.y) / 2; 
        if (map.containsKey(seat)) {
            return this.seat();
        }
        
        pq.offer(new Interval(itv.x, seat));
        pq.offer(new Interval(seat, itv.y));
        map.put(itv.x, new int[]{map.get(itv.x)[0], seat});
        map.put(itv.y, new int[]{seat, map.get(itv.y)[1]});
        map.put(seat, new int[]{itv.x, itv.y});
        return seat;
    }
    
    // O(1): use map to record pre and next so that can used to merge interval
    public void leave(int p) {
        int[] status = map.get(p);
        map.remove(p);
        map.put(status[0], new int[]{map.get(status[0])[0], status[1]});
        map.put(status[1], new int[]{status[0], map.get(status[1])[1]});
        // Merge
        pq.offer(new Interval(status[0], status[1]));
    }
}


// /**
//  * Your ExamRoom object will be instantiated and called as such:
//  * ExamRoom obj = new ExamRoom(N);
//  * int param_1 = obj.seat();
//  * obj.leave(p);
//  */