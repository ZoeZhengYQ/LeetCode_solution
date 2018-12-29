class Solution {
public:
    // using sort
    // Time: O(n logn)
    // if the majority appears more than floor(n/2) times
    // then the n/2 th element in sorted vector must be the majority element
    int majorityElement(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        return nums[nums.size()/2];
    }
};