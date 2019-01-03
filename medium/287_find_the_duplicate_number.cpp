class Solution {
public:
    // Linked list cycle!
    // key point: integers range [1, n], so no other element would point to nums[0]
    // Time: O(n)
    // Space: O(1)
    
    int findDuplicate(const vector<int>& nums) {
        if (nums.size() < 2) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        // each iteration, slow go one step, fast go two steps
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        // reset
        slow = 0;
        
        // distance(head, join) = distance(pos, join)
        // so both should only go one step
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
    
    
    // binary search
    // Time: O(n logn)
    // Space: O(1)
    /*
    int findDuplicate(const vector<int>& nums) {
        if (nums.size() < 2) return -1;
        int left = 1, right = nums.size() - 1;
        int mid = 0;
        int count = 0;
        
        while (left < right) {
            mid = (left + right) / 2;
            count = 0;
            for (int a : nums) {
                if (a <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } 
            else {
                left = mid + 1;    
            }
        }
        return right;
    }
    */
};