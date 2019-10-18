class Solution {
    // DFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private int[] rDis = new int[]{-1, 0, 1, 0};
    private int[] cDis = new int[]{0, 1, 0, -1};
    private void helper(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; ++i) {
            helper(image, sr+rDis[i], sc+cDis[i], color, newColor);   
        }
    }
}