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

    /*
    // 2019-11-13
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int l = 0, r = height.length-1;
        int lMax = height[l], rMax = height[r];
        int res = 0;
        while (l < r) {
            if (lMax > rMax) { // Decrement r
                r--;
                if (height[r] < rMax) {
                    res += (rMax - height[r]);
                } else {
                    rMax = height[r];
                }
            } else { // increment l
                l++;
                if (height[l] < lMax) {
                    res += (lMax - height[l]);
                } else {
                    lMax = height[l];
                }
            }
        }
        return res;
    }
    */
}
