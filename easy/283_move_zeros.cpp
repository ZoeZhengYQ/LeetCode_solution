class Solution {
public:
    // more simple solution
    // remember nums[j++], makes code more briliant
    /*
    void moveZeroes(vector<int>& nums) {
        int i = 0, j = 0;
        for (; i < nums.size(); ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.size(); ++j) {
            nums[j] = 0;
        }
    }
    */
    
    
    // using std::swap!!
    void moveZeroes(vector<int>& nums) {
        int len = nums.size();
        int zp = 0;     // zero pointer
        int zpn = 0;    // next non-zero pointer
        while (zp < len && zpn < len) {
            while (nums[zp] != 0 && zp < len) {
                zp++;
            } 
            zpn = zp;
            while (nums[zpn] == 0 && zpn < len) {
                zpn++;
            }
            // remember to add this if condition 
            // or it would lead to "memory not allocated!"
            if (zp < len && zpn < len) {
                swap(nums[zp++], nums[zpn++]);
            }
        }
    }
    
    
    
    // in-place
    // Time: O(n)
    // 16ms, 44.41%
    // my original solution
    /*
    void moveZeroes(vector<int>& nums) {
        if (nums.empty()) return;
        int i = 0, j = 0, cnt = 0;
        // find next non-zero element to be moved forwards
        for (i = 0; i < nums.size() - cnt; ++i) {
            while (nums[j] == 0 && j < nums.size()) {
                j++;
                cnt++;
            }
            if (j < nums.size()) {
                nums[i] = nums[j++];
            }
        }
        // set all remain element to be zero
        for (i = nums.size() - cnt; i < nums.size(); ++i) {
            nums[i] = 0;
        }
    }
    */
    
};