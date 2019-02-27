class Solution {
    private Map<String, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFSHelper(s, wordDict, map);
    }
    
    private List<String> DFSHelper(String sub, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(sub)) 
            return map.get(sub);
        
        List<String> curRes = new LinkedList<String> ();
        if (sub.length() == 0) {
            curRes.add("");
            return curRes;
        }
        
        for (String word : wordDict) {
            if (sub.startsWith(word)) {
                List<String> nextStep = DFSHelper(sub.substring(word.length()), wordDict, map);
                for (String str : nextStep) {
                    if (str.isEmpty()) {
                        curRes.add(word + "");
                    } else {
                        curRes.add(word + " " + str);
                    }
                }
            }
        }
        map.put(sub, curRes);
        return curRes;
    }
}