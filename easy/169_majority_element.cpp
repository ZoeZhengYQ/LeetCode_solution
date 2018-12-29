class Solution {
public:
    // Moore Vote Algorithm
    // Time: O(n)
    // Space: O(1)
    int majorityElement(vector<int>& nums) {
        int major, cnt = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (!cnt) { // if counter is 0
                major = nums[i];
                cnt = 1;
            }
            else {
                cnt += (nums[i] == major) ? 1 : -1;
            }
        }
        return major;
    }
    
    // using sort
    // Time: O(n logn)
    // if the majority appears more than floor(n/2) times
    // then the n/2 th element in sorted vector must be the majority element
    /*
    int majorityElement(vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        return nums[nums.size()/2];
    }
    */
    
    // sorting, using nth_element
    /*
    int majorityElement(vector<int>& nums) {
        nth_element(nums.begin(), nums.begin() + nums.size() / 2, nums.end());
        return nums[nums.size() / 2];
    }
    */
};