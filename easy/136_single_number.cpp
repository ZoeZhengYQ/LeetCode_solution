class Solution {
public:
    // Algebra Solution
    // Using XOR, the order of elements doesn't matter!
    // Remember to initialize result!
    // Time Complexity: O(n)
    int singleNumber(vector<int>& nums) {
        int result = 0;
        for (auto a : nums) {
            result ^= a;
        }
        return result;
    }
    
    
    // Naive solution LOL
    // Time Complexity: O(nlogn)
    /*
    int singleNumber(vector<int>& nums) {
            sort(nums.begin(), nums.end());
            // for (auto a : nums) {
            //     std::cout << a << " ";
            // }   
        std::cout << '\n';
            if(nums[0] != nums[1]) { return nums[0]; }
            
            int i = 2;
            // cout << i << nums[i] << nums[i+1] << endl;
            while(i != nums.size() - 1) {
                // cout << i << nums[i] << nums[i+1] << endl;
                if(nums[i] == nums[i + 1]) {
                    i += 2;
                }
                else return nums[i];
            }
            return nums[i];
        }
        */
};