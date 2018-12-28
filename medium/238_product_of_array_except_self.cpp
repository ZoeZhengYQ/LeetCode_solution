class Solution {
public:
    
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        int fromBegin = 1;
        int fromLast = 1;
        vector<int> result(n, 1);
        
        // combine the fromBegin and fromLast part together
        for(int i = 0; i < n; ++i) {
            result[i] *= fromBegin;
            fromBegin *= nums[i];
            result[n - 1 - i] *= fromLast;
            fromLast *= nums[n - 1 - i];
        }
        return result;
    
    
    // could be further simplyfied!
    // Space: O(1)
    // Time: O(n) (should be 2n)
    /*
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        int fromBegin = 1;
        int fromLast = 1;
        vector<int> result(n, 1);
        
        // set each element in result
        // as the product of all elements in nums BEFORE itself
        for(int i = 0; i < n; ++i) {
            result[i] *= fromBegin;
            fromBegin *= nums[i];
        }
        // set each element in result
        // as the product of all elements in nums AFTER itself
        for(int i = n - 1; i >= 0; --i) {
            result[i] *= fromLast;
            fromLast *= nums[i];
        }
        return result;
        */
    }
};