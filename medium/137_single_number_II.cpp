class Solution {
public:
    // solution using bitwise xor
    // Time: O(n)
    // Space: O(1)
    
    int singleNumber(vector<int>& nums) {
        int a = 0, b = 0;
        for (auto num : nums) {
            b = (b ^ num) & ~a;
            a = (a ^ num) & ~b;
        }
        return b;
    }
    
    
    // another solution
    // using a vector w/ size 32, to count the times every bit appears
    // set the bits that is not divisible by k (times other numbers appear) to be 1
    // other bits to be 0, and here comes the result!
    /*
    int singleNumber(vector<int>& nums) {
        vector<int> cnt(32, 0);
        int cur = 0;
        for (int num : nums) {
            for (int j = 31; j>=0; --j) {
                cnt[j] += (num & 1);
                num >>= 1;
                if (!num) break;
            }
        }
        
        int result = 0;
        for (int j = 31; j >= 0; --j) {
            if (cnt[j] % 3) {
                result += (1 << (31 - j));
            }
        }
        return result;
    }
    */
};