class Solution {
    // Time: O(n + m)
    // Using set
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                res++;
            }
        }
        return res;
    }
    
    // Naive Solution
    // Time: O(mn)
    /*
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> count = new HashMap<>();
        
        for (char s : S.toCharArray()) {
            count.put(s, count.getOrDefault(s, 0)+1);
        }
        
        int res = 0;
        for (char stone : count.keySet()) {
            if (J.indexOf(stone) >= 0) {
                res += count.get(stone);
            }
        }
        return res;
    }
    */
}