class Solution {
    // 一个点最多出现4次(1次为角点，2次在边上，4次在内部)
    // Time: O(n)
    // Space: O(1)
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
        
        int area = 0;
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        Set<String> dots = new HashSet<>();
        for (int[] rec : rectangles) {
            x1 = Math.min(x1, rec[0]);
            y1 = Math.min(y1, rec[1]);
            x2 = Math.max(x2, rec[2]);
            y2 = Math.max(y2, rec[3]);
            
            area += (rec[2]-rec[0]) * (rec[3]-rec[1]);
            
            if (!dots.add(rec[0] + "," + rec[1])) dots.remove(rec[0] + "," + rec[1]);
            if (!dots.add(rec[0] + "," + rec[3])) dots.remove(rec[0] + "," + rec[3]);
            if (!dots.add(rec[2] + "," + rec[1])) dots.remove(rec[2] + "," + rec[1]);
            if (!dots.add(rec[2] + "," + rec[3])) dots.remove(rec[2] + "," + rec[3]);
        }
        if (dots.size() != 4 || !dots.contains(x1 + "," + y1) || !dots.contains(x1 + "," + y2) || 
            !dots.contains(x2 + "," + y1) || !dots.contains(x2 + "," + y2))
            return false;
        
        return area == (x2-x1) * (y2-y1);
    }
    
    /*
    // Naive solution: TLE
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] rec : rectangles) {
            minX = Math.min(minX, rec[0]);
            minX = Math.min(minX, rec[2]);
            maxX = Math.max(maxX, rec[0]);
            maxX = Math.max(maxX, rec[2]);
            minY = Math.min(minY, rec[1]);
            minY = Math.min(minY, rec[3]);
            maxY = Math.max(maxY, rec[1]);
            maxY = Math.max(maxY, rec[3]);
        }
        
        int n = maxX - minX;
        int m = maxY - minY;
        
        Set<String> covered = new HashSet<>();
        
        for (int[] rec : rectangles) {
            for (int x = rec[0]-minX; x < rec[2]-minX; ++x) {
                for (int y = rec[1]-minY; y < rec[3]-minY; ++y) {
                    String cood = x + "," + y;
                    if (covered.contains(cood)) {
                        System.out.println("Overlap! " + cood);
                        return false;   
                    }
                    covered.add(cood);
                }
            }
        }
        return covered.size() == (n*m);
    }
    */
}