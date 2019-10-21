class Solution {
    // can do with n 2sum
    // Time O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int l = i + 1, r = nums.length - 1, target = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l-1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;
                } else if (nums[l] + nums[r] > target) {
                    r--;
                } else {
                    l++;
                }
                
            }
        }
        return res;
    }
}

/*
class Solution {
    // n two sum
    // Time: O(n^2)
    private List<List<Integer>> res;
    
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>(); 
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; ++i) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                doTwoSum(nums, i);   
            }
        }
        return res;
    }
    
    private void doTwoSum(int[] nums, int start) {
        if (start >= nums.length-2) return;
        int i = start + 1, j = nums.length-1;
        int num = nums[start];
        while (i < j) {
            int sum = num + nums[i] + nums[j];
            if (sum < 0) {
                i++;
                while (i < j && nums[i] == nums[i-1]) { i++; }
            } else if (sum > 0) {
                j--;
                while (j > i && nums[j] == nums[j+1]) { j--; }
            } else {
                res.add(Arrays.asList(num, nums[i], nums[j]));
                // 注意这边也要更新i和j！
                i++;
                j--;
                while (i < j && nums[i] == nums[i-1]) i++;
                while (i < j && nums[i] == nums[j+1]) j--;
            }  
        }
    }
}
*/