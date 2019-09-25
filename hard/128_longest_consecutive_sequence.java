class Solution {
    
    // Disjoint Set: Union Find
    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) continue;
            map.put(nums[i], i);
            if (map.containsKey(nums[i]+1)) {
                uf.union(map.get(nums[i]+1), i);
            }
            if (map.containsKey(nums[i]-1)) {
                uf.union(map.get(nums[i]-1), i);
            }
        }
        return uf.maxSize();
        
    }
    
    private class UnionFind {
        private int[] sets;
        public UnionFind(int len) {
            sets = new int[len];
            // initialize the sets that every node's 
            // root is themselves
            for (int i = 0; i < len; ++i) {
                sets[i] = i;
            }
        }
        
        public int root(int idx) {
            while (sets[idx] != idx) {
                sets[idx] = sets[sets[idx]];
                idx = sets[idx];
            }
            // The root should point to itself
            return idx;
        }
        
        public void union(int x, int y) {
            // Remember! set root istead of setting itself!
            sets[root(x)] = root(y);
        }
        
        public int maxSize() {
            int[] cnt = new int[sets.length];
            int max = 0;
            for (int i = 0; i < sets.length; ++i) {
                int r = root(i);
                cnt[r]++;
                max = Math.max(max, cnt[r]);
            }
            for (int i : sets) {
                System.out.print(i + " ");
            }
            System.out.println("");
            return max;
        }
    }
    
    
    // Keep track of boundaries and sum
    /*
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int left = map.getOrDefault(num-1, 0);
            int right = map.getOrDefault(num+1, 0);
            int sum = 1 + left + right;
            map.put(num, sum);
            
            res = Math.max(res, sum);
            // Extend boundary
            // If num has no neighbors, 
            // this would do nothing
            map.put(num-left, sum);
            map.put(num+right, sum);
        }
        return res;
    }
    */
}