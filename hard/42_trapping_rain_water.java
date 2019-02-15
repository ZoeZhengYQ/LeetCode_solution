class Solution {
    // Time: O(n)
    // Space: O(1)
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // leftmax is smaller than rightmax, so the (leftmax-height[left]) water can be stored
            if (leftMax<rightMax) {
                res += (leftMax - height[left++]);
            } else {
                res += (rightMax - height[right--]);
            }
        }
        return res;
    }
}