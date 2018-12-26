class Solution {
public:
    // Bit wise solution using XOR!
    // Runtime Complexity: O(n)
    // Space Complexity: O(1)
    // remember Two's complement!
    
    vector<int> singleNumber(vector<int>& nums) {
        // if (nums.empty()) return nums;
        int diff = std::accumulate(nums.begin(), nums.end(), 0, std::bit_xor<int>());
        // find the last set bit
        diff &= -diff;
        
        vector<int> result = {0, 0};
        
        for (int a : nums) {
            // if the bit is not set
            // remember to add () here or it would lead to wrong result
            if ((a & diff) == 0) {
                result[0] ^= a;
            } 
            // else if bit is set
            else {        
                result[1] ^= a;
            }
        }
        return result;
    }
};