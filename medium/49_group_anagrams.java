class Solution {
    // The easiest way to find a key as a map is to convert it into string!!
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int j = 0; j < str.length(); ++j) {
                count[str.charAt(j)-'a']++;
            }
            
            String key = Arrays.toString(count);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}