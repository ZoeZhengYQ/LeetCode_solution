class Solution {
    // Binary search
    // Time: O(log(min(length1, length2)))
    // Space: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Good way to make first array short!!
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        
        int l = 0;
        int h = len1;
        while (l <= h) {
            // partition for nums1
            int par1 = (l + h) / 2;
            // partition for nums2
            // the +1 works for both odd and even number of elements
            // would always leave one more on left when number is odd
            int par2 = (total + 1) / 2 - par1;
            
            // Tricks to eliminate edge cases!
            int maxLeft1 = (par1 == 0) ? Integer.MIN_VALUE : nums1[par1-1];
            int maxLeft2 = (par2 == 0) ? Integer.MIN_VALUE : nums2[par2-1];
            int minRight1 = (par1 == len1) ? Integer.MAX_VALUE : nums1[par1];
            int minRight2 = (par2 == len2) ? Integer.MAX_VALUE : nums2[par2];
            
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if (total % 2 == 0) {
                    return ((double)Math.max(maxLeft1, maxLeft2) + 
                                    Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return (double)Math.max(maxLeft1, maxLeft2);
                }
            }
            // Elements in left too large
            else if (maxLeft1 > minRight2) {
                h = par1 - 1;
            } else {
                l = par1 + 1;
            }
        }
        return -1;
    }
}