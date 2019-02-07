class Solution {
    
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;
        
        int front = 0;
        int rear = height.length - 1;
        
        int width = height.length - 1;
        int max = 0;
        int vol = 0;
        // the shorter one determined the volumn
        // using this feature we could eliminates lots of cases
        while (front < rear) {
            if (height[front] < height[rear]) {
                vol = height[front] * width;
                front++;
            } else {
                vol = height[rear] * width;
                rear--;
            }
            max = Math.max(vol, max);
            width--;
        }
        return max;
    }
}