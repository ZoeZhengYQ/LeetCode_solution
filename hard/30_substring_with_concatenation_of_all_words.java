class Solution {
    // Two map solution
    // Time: O(n^2)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // Create a map to count frequency in the string array
        Map<String, Integer> frqCount = new HashMap<>();
        for (String word : words) {
            frqCount.put(word, frqCount.getOrDefault(word, 0) + 1);
        }
        
        int num = words.length;     // Total number of words
        if (num == 0) return res;
        int len = words[0].length();    // Length of a single word
        int size = s.length();      // Size of the string
        for (int i = 0; i < size - num * len + 1; ++i) {
            Map<String, Integer> visited = new HashMap<>();
            int k = 0;
            while (k < num) {
                String slice = s.substring(i+k*len, i+(k+1)*len);
                if (frqCount.containsKey(slice)) {
                    visited.put(slice, visited.getOrDefault(slice, 0) + 1);
                    if (visited.get(slice) > frqCount.get(slice)) {
                        break;
                    }
                } else {
                    break;
                }
                k++;
            }
            if (k == num) {
                res.add(i);
            }
        }
        return res;
    }
}