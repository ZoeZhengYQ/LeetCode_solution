class Solution {
    // Two-way BFS
    // 两个圆的切点！
    // 18ms 90.43%
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) return 0;
        
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>(); 
        
	    int strLen = beginWord.length();
	    HashSet<String> visited = new HashSet<String>();
	
        int res = 1;
	    beginSet.add(beginWord);
	    endSet.add(endWord);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            
            Set<String> curSet = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < strLen; ++i) {
                    char[] cArr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; ++c) {
                        cArr[i] = c;
                        String next = new String(cArr);
                        if (endSet.contains(next)) { return res+1; }
                        if (wordSet.contains(next) && !visited.contains(next)) {
                            curSet.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            beginSet = curSet;
            res++;
        }
        return 0;
    }
    // BFS: next step is to change a character in string
    /*
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) return 0;
        
        int res = 1;
        Set<String> visited = new HashSet<>();
        Queue<String> todo = new LinkedList<>();
        todo.offer(beginWord);
        visited.add(beginWord);
        while (!todo.isEmpty()) {
            int size = todo.size();
            for (int s = 0; s < size; ++s) {
                String cur = todo.poll();
                for (int i = 0; i < cur.length(); ++i) {
                    char[] cArr = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; ++c) {
                        cArr[i] = c;
                        String next = new String(cArr);
                        if (next.equals(endWord)) return res+1;
                        if (!visited.contains(next) && wordSet.contains(next)) {
                            todo.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
    */
}