class Solution {
    // Trie, DFS
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        int idx;    // Index of word in words list
        
        TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
            this.idx = -1;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; ++i) {
                if (children[i] != null) {
                    char c = (char)((int)'a' + i);
                    sb.append(c + ",");
                }
            }
            return "[" + isEnd + ", " + sb.toString() + "]";
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0 || board.length == 0 || board[0].length == 0) return res;
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(words, board, i, j, root, res);
            }
        }
        
        return res;
    }
    
    
    private int[] xDis = new int[]{-1, 0, 1, 0};
    private int[] yDis = new int[]{0, 1, 0, -1};
    
    private void dfs(String[] words, char[][] board, int x, int y, TrieNode cur, List<String> res) {
        int xLen = board.length;
        int yLen = board[0].length;
        char c = board[x][y];
        if (c == '-' || cur.children[c-'a'] == null) { 
            return; 
        }
        cur = cur.children[c-'a'];
        if (cur.isEnd) { 
            if (cur.idx >= 0) {
                // Elimination duplicate!
                res.add(words[cur.idx]);
                cur.idx = -1;
            }
        }
        board[x][y] = '-';  // Set visited
        for (int i = 0; i < 4; ++i) {
            int newX = x + xDis[i];
            int newY = y + yDis[i];
            if (newX < 0 || newX >= xLen || newY < 0 || newY >= yLen) continue;
            dfs(words, board, newX, newY, cur, res);
        }
        board[x][y] = c;
    }
    
    // Build TrieTree
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        int wordIdx = 0;
        for (String word : words) {
            TrieNode cur = root;
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; ++i) {
                int idx = arr[i]-'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new TrieNode();
                }
                cur = cur.children[idx];
            }
            cur.isEnd = true;
            cur.idx = wordIdx++;
        }
        return root;
    } 
}