class Solution {
    // Binary Search to find peek
    //  Note: the questions guarantee that 
    //      1) no adjancent elements are equal
    //      2) peek element is guaranteed existed
    // This is why BS would work in this unsorted case, 
    // we only need to find ONE peek
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) return nums.length-1;
        
        int l = 0, r = nums.length-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] < nums[mid+1]) {
                l=mid+1;
            } else {
                r=mid;
            }
        }
        return l;
    }
}