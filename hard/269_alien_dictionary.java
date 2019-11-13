class Solution {
    // Topological Sorting
    // m -> # of word, n -> avg. length
    // Time: O(mn) for degree init, O(mn) for build graph, O(mn) for BFS?
    // Space: O(mn) for degree, O(mn) for map, O(mn) for ll in BFS
    public String alienOrder(String[] words) {
        int len = words.length;
        if (len == 0) return ""; // If length == 1, still possible
        
        String res = "";
        Map<Character, Set<Character>> nodes = new HashMap<>(); // Adjacency list graph
        Map<Character, Integer> degree = new HashMap<>(); // record number of parent node for every node
        
        // Loop and init degree with EVERY node
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        
        // Build degree & map
        for (int i = 1; i < len; ++i) {
            String pre = words[i-1];
            String cur = words[i];
            int sp = 0, sc = 0;
            int maxLen = Math.min(pre.length(), cur.length());
            while (sp < maxLen && sc < maxLen) {
                char cp = pre.charAt(sp);
                char cc = cur.charAt(sc);
                if (cp != cc) {
                    if (!nodes.containsKey(cp)) {
                        nodes.put(cp, new HashSet<>());
                    }
                    if (nodes.get(cp).add(cc)) { // Eliminate duplication
                        // e.g. ["za", "zb", "ca", "cb"]
                        // a->b appears two times
                        // So only increment when cc is not presented in cp's child set
                        degree.put(cc, degree.get(cc)+1);        
                    }
                    break;
                }
                sp++;
                sc++;
            }
        }
        
        // BFS
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()) {
            // Only add node whose parents are all added to result
            if (degree.get(c) == 0) q.offer(c);
        }
        
        while (!q.isEmpty()) {
            char c = q.poll();
            res += c;
            if (nodes.containsKey(c)) {
                for (char child : nodes.get(c)) {               
                    degree.put(child, degree.get(child)-1);   
                    if (degree.get(child) == 0) q.offer(child);
                }
            }
        }
        
        if (res.length() != degree.size()) { // Not a DAG
            return "";
        }
        return res;
    }
}