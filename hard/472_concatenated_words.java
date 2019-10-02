class Solution {
    // DP: N - word break
    // Time: O(n^2 m)
    // Space: O(n)
    //  n - largest length of word, m - num of words
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
}