class Solution {
    // hashmap + two pointers
    // Time: O(n)
    // Space: O(n)
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int l = 0, r = 0; r < len; ++r) {
            if (map.containsKey(s.charAt(r))) {
                // Add the max here to make sure 
                // we are checking the current window
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
    // Solution using hashmap to store char and position
    // But have to update map once there is overlap
    // Could have better solution using two pointers
    /*
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        
        char[] charArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int maxLen = 0;
        int curLen = 0;
        while (i < len) {
            if (map.containsKey(charArr[i])) {
                int prev = map.get(charArr[i]);
                map = new HashMap<>();
                for (int j = prev; j < i; ++j) {
                    map.put(charArr[j], j);
                }
                curLen = i - prev;
            } else {
                curLen++;
            }
            map.put(charArr[i], i);
            i++;
            maxLen = Math.max(curLen, maxLen);
        }
        return maxLen;
    }
    */
}