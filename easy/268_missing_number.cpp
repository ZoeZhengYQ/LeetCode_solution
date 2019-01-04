class Solution {
public:
    // sum
    
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        return ((n + 1) * n / 2) - accumulate(nums.begin(), nums.end(), 0);
    }
    
    
    // bit manipulation
    // 1 ^ 1 = 0; 0 ^ 1 = 1;
    /*
    int missingNumber(vector<int>& nums) {
        int res = nums.size();
        int i = 0;
        for (int num : nums) {
            res ^= num;
            res ^= i++;
        }
        return res;
    }
    */
};