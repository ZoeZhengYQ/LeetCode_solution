class Solution {
    // Use a map to count frequency and another to record the first and last occurance of a element
    // Time: O(n)
    // Space: O(n)
    // or could use one Map to store frequency and position all at once
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
    
        int len = nums.length;
        int degree = 0;
        int res = len;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer[]> position = new HashMap<>();
        
        for (int i = 0; i < len; ++i) {
            // count frequency
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            // update degree
            degree = Math.max(count.get(nums[i]), degree);
            
            // record the first and last occurance of the element
            if (position.get(nums[i]) == null) {
                position.put(nums[i], new Integer[2]);
                position.get(nums[i])[0] = i;
            }
            position.get(nums[i])[1] = i;
        }
        
        for (Map.Entry<Integer, Integer> set : count.entrySet()) {
            if (set.getValue() != degree) continue;
            Integer[] range = position.get(set.getKey());
            res = Math.min(res, range[1] - range[0] + 1);
        } 
        return res;
    }
}