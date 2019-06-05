class Solution {
    // Binary Search
    // Max value r is the summary of all elements
    // Min value l is the max element
    // So we make mid = (l+r)/2 as start point
    // Time: O(log(sumOfArray - max) * n)
    // Space: O(1)
    public int splitArray(int[] nums, int m) {
        // Sum
        long r = 0;
        // Max element
        int l = 0;
        
        for (int num : nums) {
            l = num > l ? num : l;
            r += num;
        }
        
        if (m == 1) return (int)r;
        
        while (l <= r) {
            long mid = (l + r) / 2;
            if (binarySearch(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = (int)mid + 1;
            }
        }
        return (int)l;
    }
    
    private boolean binarySearch(long target, int[] nums, int m) {
        int count = 1;
        long curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > target) {
                curSum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // DP: dp[i, m+1] = min of all (max(dp[j, m], sum[i]-sum[j]))  
    //      where m <= j <= i
    // Time: O(m*n^2)
    // Space: O(n)
    // 12ms 37.96%
    // Mind the case when element in num is Integer.MAX_VALUE
    /*
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        // sum[i]: summary of i elements in nums
        int[] sum = new int[len+1];
        int[] dp = new int[len];
        
        // Set sum array
        sum[0] = 0;
        for (int i = 0; i < len; ++i) {
            sum[i+1] = sum[i] + nums[i];
        }
        
        // Init dp array to case m = 1 (sum of all elements)
        for (int i = 0; i < len; ++i) {
            dp[i] = sum[i+1];
        }
        // print(dp);
        
        // Calculate m - 1 times
        for (int k = 2; k <= m; ++k) {
            // i elements
            for (int i = len; i >= k; --i) {
                int res = Integer.MAX_VALUE;
                for (int j = k; j <= i; ++j) {
                    int tmp = Math.max(dp[j-2], sum[i] - sum[j-1]);
                    
                    // Using the condition that elements are non-negative
                    // If tmp <= 0, that means the result exceed max value
                    // in this case we just leave it as max value
                    if (tmp < 0) {
                        tmp = Integer.MAX_VALUE;
                    }
                    if (tmp < res) {
                        res = tmp; 
                    } else {
                        break;
                    }
                }
                dp[i-1] = res;
            }
            // print(dp);
        }
        return dp[len-1];
        
    }
    
    private void print(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }
    */
}