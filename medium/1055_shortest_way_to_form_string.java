class Solution {
    // Binary Search
    // Time: O(n logm)
    // Space: O(m)
    public int shortestWay(String source, String target) {
        char[] sArr = source.toCharArray();
        char[] tArr = target.toCharArray();
        List<Integer>[] map = new List[26];
        int pre = 0;
        int cnt = 1;
        for (int i = 0; i < 26; ++i) map[i] = new ArrayList<>();
        for (int s = 0; s < sArr.length; ++s) map[sArr[s]-'a'].add(s);
        for (int t = 0; t < tArr.length; ) {
            List<Integer> tar = map[tArr[t] - 'a'];
		    if (tar.isEmpty()) return -1;
		    int k = Collections.binarySearch(tar,pre);
		    if (k < 0) k = -k - 1;
		    if (k == tar.size()) {
			    cnt++;
			    pre = 0;
		    } else {
			    pre = tar.get(k) + 1;
			    t++;
		    }
        }
        return cnt;
    }
    
    // Time: O(mn)
    // n -> length of target, m -> length of source
    // Space: O(1)
    /*
    public int shortestWay(String source, String target) {
        int sLen = source.length(), tLen = target.length();
        int s = 0, t = 0;
        int count = 0;
        // Eliminate the initial case where s==startIdx(=0)
        int startIdx = -1;
        for ( ; t < tLen; ++t) {
            char curT = target.charAt(t);
            while (curT != source.charAt(s)) {
                // New round
                if (s == 0) count++;
                // No matching in source
                if (s == startIdx) return -1;
                // Increment after the conditions above
                s = (s + 1) % sLen;
            }
            if (s == 0) count++;
            startIdx = s;
            s = (s + 1) % sLen;
        }
        return count;
    }
    */
}