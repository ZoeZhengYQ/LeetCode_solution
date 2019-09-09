class Solution {
    // Two pointers
    // 挖空的题目都可以这么做！
    // Time: O(n)
    // Space: O(n)
    public int maximumSum(int[] arr) {
        int len = arr.length;
        if (len == 0) return Integer.MIN_VALUE;
        if (len == 1) return arr[0];
        
        int[] maxEnd = new int[len];
        maxEnd[0] = arr[0];
        int[] maxStart = new int[len];
        maxStart[len-1] = arr[len-1];
        int res = arr[0];
        for (int i = 1; i < len; ++i) {
            maxEnd[i] = Math.max(maxEnd[i-1]+arr[i], arr[i]);
            res = Math.max(res, maxEnd[i]);
            int idx = len-1-i;
            maxStart[idx] = Math.max(maxStart[idx+1]+arr[idx], arr[idx]);
        }
        // Deal with one deletion
        // Skip the first and the last element
        // Cuz it's already included in no deletion check
        for (int k = 1; k < len-1; ++k) {
            res = Math.max(res, maxEnd[k-1]+maxStart[k+1]);
        }
        return res;
    }
    
    // Time: O(n^2)
    // Time limit exceed
    /*
    public int maximumSum(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        
        int max = helper(arr);
        
        for (int i = 0, k = 0; i < arr.length; ++i) {
            if (arr[i] >= 0) continue;
            int[] newArr = removeEle(arr, i);
            int cur = helper(newArr);
            max = Math.max(cur, max);
        }
        return max;
    }
    
    private int helper(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0];
        int maxVal = res[0];
        for (int i = 1; i < arr.length; ++i) {
            res[i] = (res[i-1] < 0) ? arr[i] : arr[i] + res[i-1];
            if (res[i] > maxVal) {
                maxVal = res[i];
            }
        }
        return maxVal;
    }
    
    private int[] removeEle(int[] arr, int idx) {
        int[] anotherArr = new int[arr.length-1];
        for (int i = 0, k = 0; i < arr.length; ++i) {
            if (i == idx) {continue;}
            anotherArr[k++] = arr[i];
        }
        return anotherArr;
    }
    */
}