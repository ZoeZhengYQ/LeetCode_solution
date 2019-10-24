class Solution {
    // Compute overlap with max & min!
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = Math.abs(C-A) * Math.abs(D-B);
        res += Math.abs(G-E) * Math.abs(H-F);
        
        // Tricky part!!
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        // If overlap
        if(right > left && top > bottom) {
            res -= (right - left) * (top - bottom);   
        }
        return res;
    }
    // Naive solution
    // Sum area - overlap area
    /*
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[] xarr = new int[]{A, C, E, G};
        int[] yarr = new int[]{B, D, F, H};
        Arrays.sort(xarr);
        Arrays.sort(yarr);
        int res = recArea(A, B, C, D) + recArea(E, F, G, H);
        if (isRecOverlap(A, B, C, D, E, F, G, H)) {
            res -= recArea(xarr[1], yarr[1], xarr[2], yarr[2]); 
        }
        return res;
    }
    
    private boolean isRecOverlap(int A, int B, int C, int D, int E, int F, int G, int H) {
        return intervalOverlap(A, C, E, G) && intervalOverlap(B, D, F, H);
    }
    
    private boolean intervalOverlap(int s1, int e1, int s2, int e2) {
        if (s2 < s1) return intervalOverlap(s2, e2, s1, e1);
        return e1 > s2;
    }
    
    private int recArea(int x1, int y1, int x2, int y2) {
        return Math.abs(x2-x1) * Math.abs(y2-y1);
    }
    */
}