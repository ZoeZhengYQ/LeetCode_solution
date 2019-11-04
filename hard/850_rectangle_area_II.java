class Solution {
    // Split rectangles to non-overlapping part and sum them all
    // Time: O(n^2)
    //  the size of rectangle list would be about some number k times n
    //  for every new rectangle, it need to compare to kn
    private List<int[]> list;
    public int rectangleArea(int[][] rectangles) {
        int cnt = rectangles.length;
        if (cnt == 0) return 0;
        this.list = new ArrayList<>();
        for (int[] rec : rectangles) {
            addRectangle(rec, 0);
        }
        long res = 0;
        int mod = 1000000007;
        for (int[] rec : list) {
            res += (long)(rec[2]-rec[0]) * (long)(rec[3] - rec[1]);
            res %= mod;
        }
        return (int)res;
    }
    
    private void addRectangle(int[] curRec, int start) {
        if (start >= list.size()) {
            list.add(curRec);
            return;
        }
        
        int[] rec = list.get(start);
        
        if (!isOverlap(rec, curRec)) {
            addRectangle(curRec, start+1);
            return;
        }
        
        // case 1: left
        if (curRec[0] < rec[0]) {
            int[] c1 = new int[]{curRec[0], curRec[1], rec[0], curRec[3]};
            addRectangle(c1, start+1);
        }
        
        // case 2: right
        if (curRec[2] > rec[2]) {
            int[] c2 = new int[]{rec[2], curRec[1], curRec[2], curRec[3]};
            addRectangle(c2, start+1);
        }
        
        // case 3: bottom
        if (curRec[1] < rec[1]) {
            int[] c3 = new int[]{Math.max(curRec[0], rec[0]), curRec[1], Math.min(curRec[2], rec[2]), rec[1]};
            addRectangle(c3, start+1);
        }
        
        // case 4: top
        if (curRec[3] > rec[3]) {
            int[] c4 = new int[]{Math.max(curRec[0], rec[0]), rec[3], Math.min(curRec[2], rec[2]), curRec[3]};
            addRectangle(c4, start+1);
        }
    }
    
    private boolean isOverlap(int[] r1, int[] r2) {
        int left = Math.max(r1[0], r2[0]);
        int right = Math.min(r1[2], r2[2]);
        int bottom = Math.max(r1[1], r2[1]);
        int top = Math.min(r1[3], r2[3]);
        
        return (left < right && bottom < top);
    }
}