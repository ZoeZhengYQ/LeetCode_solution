class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        // count the total step we need to move a element
        int totalCnt = 0;
        // count numbers of duplicate of current value
        int cnt = 0;
        // remember current value
        int curVal = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            if (curVal == nums[i]) {
                cnt++;
                // only when current value duplicate more than once
                // then we need to increment totalCnt
                if (cnt > 1) { totalCnt++; }
            }
            // update current value and cnt
            else {
                curVal = nums[i];
                cnt = 0;
            }
            // only when totalCnt is larger than 0 that we need to move
            if (totalCnt > 0){
                nums[i - totalCnt] = nums[i];
            }
        }
        return nums.length - totalCnt;
    }
}