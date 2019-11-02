class Solution {
    // Greedy
    // Two sub problem:
    // 1) find maxNumber in ONE array with k digits
    // 2) find the maxNumber in TWO array with all of their digits
    // Time: O((m+n) ^ 3)
    //  isGreater: O(m+n)
    //  mergeTwoNum: O(m+n)
    //  maxNumInOne: O(n^2)
    //  for loop O(k) -> O(m+n)
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] maxNum = new int[k];
        for (int i = Math.max(0, k-len2); i <= k && i <= len1; ++i) {
            int[] arr1 = maxNumberInOne(nums1, i);
            int[] arr2 = maxNumberInOne(nums2, k-i);
            int[] cur = mergeTwoNum(arr1, arr2);
            if (isGreater(cur, 0, maxNum, 0)) { maxNum = cur; }
        }
        return maxNum;
    }
    
    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        int len1 = nums1.length, len2 = nums2.length;
        while (i < len1 && j < len2 && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == len2 || (i < len1 && nums1[i] > nums2[j]);
    }
    
    private int[] mergeTwoNum(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1+len2];
        int i = 0, j = 0, idx = 0;
        while (i < len1 && j < len2) {
            // 注意这边不能只是单纯比较当前两个位数的大小
            // 例如 [6, 7] [6, 0, 4]
            // 假如取用了第二个6，下次比较的就会是第一个6和0， 结果会是[6,6,7,0,4]，但是实际上应该是[6,7,6,0,4]
            res[idx++] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }
    
    private int[] maxNumberInOne(int[] nums, int limit) {
        int len = nums.length;
        int[] res = new int[limit];
        // i: iterate through array
        // j: idx to simulate a stack
        for (int i = 0, j = 0; i < len; ++i) {
            while (len-i+j > limit && j > 0 && res[j-1] < nums[i]) { 
                // POP from stack if the top element is smaller than nums[i], until
                // 1) no enough number left to fulfill limit (len-i+j <= limit)
                //   注意 len i j limit都是表示“多少个”而不是“idx”
                // 2) stack empty (j <= 0)
                j--; 
            }
            if (j < limit) res[j++] = nums[i];
        }
        return res;
    }
}