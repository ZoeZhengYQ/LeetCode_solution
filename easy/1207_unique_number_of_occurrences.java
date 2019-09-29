class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : arr) {
            cnt.put(i, cnt.getOrDefault(i, 0)+1);
        }
        
        Set<Integer> used = new HashSet<>();
        for (int key : cnt.keySet()) {
            int c = cnt.get(key);
            if (used.contains(c)) {
                return false;
            } 
            used.add(c);
        }
        return true;
    }
}