class Solution {
    // Sliding window
    // Time: O(n)
    // Space: O(1)
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < s.length()) {
            maxCost -= Math.abs(s.charAt(r) - t.charAt(r));
            r++;
            if (maxCost >= 0) {
                max = Math.max(max, r - l);
            }
            while (maxCost < 0) {
                maxCost += Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
        }
        return max;
    }

    /*
    // Time: O(n^2)
    // For every number, find the longest substring w/in budget that ends with this number
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        if (len == 0) return 0;
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        int[] costs = new int[len];
        for (int i = 0; i < len; ++i) {
            costs[i] = getCost(sArr[i], tArr[i]);
        }
        
        int maxLen = 0;
        for (int i = 0; i < len; ++i) {
            maxLen = Math.max(maxLen, goBack(costs, maxCost, i));
        }
        return maxLen;
    }
    
    private int goBack(int[] costs, int maxCost, int idx) {
        int len = 0, rest = maxCost;
        while (idx >= 0 && rest >= 0) {
            if (costs[idx] > maxCost) return 0;
            if (costs[idx] <= rest) {
                len++;
                rest -= costs[idx];
            } else {
                break;
            }
            idx--;
        }
        return len;
    }
    
    private int getCost(char a, char b) {
        return Math.abs(a - b);
    }
    */
}