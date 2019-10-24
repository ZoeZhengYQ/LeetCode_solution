class Solution {
    // Interval overlap: left1 < right2 && left2 < right1
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && 
               rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
    // x interval: [x1, x2], y interval: [y1, y2]
    // check if interval have overlap
    // note that [6, 8] & [8, 10] do NOT considered as overlap
    /*
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return haveOverlap(rec1[0], rec1[2], rec2[0], rec2[2])  && 
            haveOverlap(rec1[1], rec1[3], rec2[1], rec2[3]);
    }
    
    private boolean haveOverlap(int s1, int e1, int s2, int e2) {
        if (s2 < s1) return haveOverlap(s2, e2, s1, e1);
        return e1 > s2;
    }
    */
}