public class Solution {
    // Solution for N sum
    // 1. 2 sum
    // 2. reduce N sum to N-1 sum
    // 3. should be aware of one sum for the kSum solution
    // Time: 2 sum O(n^(k-1))
    // Space: O(k)
    private int len = 0;
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    
    // General k sum
    private List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (start >= len) { return res; }
        // 2 sum
        if (k == 1) { return oneSum(nums, target); }
        if (k == 2) {
            int l = start;
            int r = len - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    // Skip duplication
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r-1]==nums[r]) r--;
                    l++;
                    r--;
                }
                // move right
                else if (sum < target) { l++; } 
                // move left
                else { r--; }
            }
        } else {
            // len - (k - 1), leave k elements on right to do k-1 sum
            for (int i = start; i < len - k + 1; ++i) {
                List<List<Integer>> partial = kSum(nums, target-nums[i], k-1, i+1);
                if (partial != null) {
                    for (List<Integer> list : partial) {
                        // Insert to front
                        list.add(0, nums[i]);
                    }
                    res.addAll(partial);
                }
                while (i < len - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return res;
    }
    
    private List<List<Integer>> oneSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && (i == 0 || nums[i] != nums[i - 1])) {
                res.add(Arrays.asList(nums[i]));
            }
        } 
        
        return res;
    }
}