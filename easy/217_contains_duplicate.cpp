class Solution {
public:
    // count using unordered map
    // could also use sort and check if two continuous number is equal
    // 40ms
    
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int, int> counts;
        for(int a : nums) {
            counts[a]++;
        }
        for(auto cnt : counts) {
            if (cnt.second > 1) {
                return true;
            }
        }
        return false;
    }
    
    // other simple one line solution
    // using set in c++ where keys should be unique
    // 56 ms
    /*
    bool containsDuplicate(vector<int>& nums) {
        return nums.size() > std::set<int> (nums.begin(), nums.end()).size();
    }
    */
};