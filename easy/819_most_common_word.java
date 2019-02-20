class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<String> (Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<> ();
        
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        
        for (String s: words) {
            if (!ban.contains(s)) {
                count.put(s, count.getOrDefault(s, 0) + 1);
            }
        }
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}