class Solution {
	// 2020.1.13
    // Brute force: DP
    // Time: O(n*k^2), n: number of words, k: length of single word
    // Space: O(n*k)
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String word : words) { set.add(word); }
        for (String word : words) {
            if (helper(set, word)) {
                res.add(word);
            }
        }
        return res;
    }
    
    private boolean helper(Set<String> set, String word) {
        int l = word.length();
        if (l == 0) { return false; }
        // cnt array remember that at position i, there's cnt[i] words that can be concatenated
        int[] cnt = new int[l];
        for (int i = 0; i < l; ++i) {
            for (int j = 0; j < i; ++j) {
                if (cnt[j] > 0) { 
                    // If current position have a previous word, 
                    // check if j+1 to i is a valid word
                    if (set.contains(word.substring(j+1, i+1))) {
                        cnt[i] = cnt[j]+1;
                        // Do NOT forget the break, or it will TLE
                        break;
                    }
                }
            }
            if (set.contains(word.substring(0, i+1))) {
                cnt[i] = Math.max(cnt[i], 1);
            }
        }
        // Concatenated need AT LEAST TWO!
        return cnt[l-1] > 1;
    }

    // DP: N - word break
    // Time: O(n^2 m)
    // Space: O(n)
    //  n - largest length of word, m - num of words
    /*
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int len = words.length;
        List<String> res = new ArrayList<>();
        if (len == 0) return res;
        
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        
        for (String word : words) {
            if (helper(set, word)) {
                res.add(word);
            }
        }
        return res;
    }
    
    private boolean helper(Set<String> set, String word) {
        
        int l = word.length();
        if (l == 0) // Eliminate the case where input is [""]
            return false;
        int[] check = new int[l];
        for (int i = 0; i < l; ++i) {
            for (int j = 0; j < i; ++j) {
                if (check[j] > 0) {
                    if (set.contains(word.substring(j+1, i+1))) {
                        check[i] = check[j]+1;
                        break;
                    }
                }
            }
            if (set.contains(word.substring(0, i+1))) {
                check[i] = Math.max(check[i], 1);
            }
        }
        return check[l-1] > 1;
    }
    */
}