class Solution {
    // one-pass
    // Time: O(n)
    // Space: O(1) largest number is 2
    public void sortColors(int[] nums) {
        int idx = 0;
        int l = -1;
        int h = nums.length;
        
        while (idx < h) {
            boolean flg = false;
            if (nums[idx] == 0) {
                nums[idx] = nums[++l];
                nums[l] = 0;
                
            }
            // 如果在这里改变过2的位置，很可能换过来的是0，所以需要再确认一次，所以不能idx++
            if (nums[idx] == 2) {
                nums[idx] = nums[--h];
                nums[h] = 2;
                flg = true;
            }
            if (!flg) idx++;
        } 
    }
    
    
    // two pass solution: counting sort
    // Time: O(n)
    // Space: O(1) largest number is 2
    /*
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        
        int curIdx = 0;
        for (int i = 0; i < 3; ++i) {
            while (count[i] > 0) {
                nums[curIdx++] = i;
                count[i]--;
            }
        }
        
        return;
    }
    */
    
}