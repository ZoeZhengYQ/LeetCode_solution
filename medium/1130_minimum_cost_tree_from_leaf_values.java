class Solution {
    // God's eye view
    // Time: O(n)
    // Space: O(n)
    /*
    public int mctFromLeafValues(int[] arr) {
        int minSum = 0;
        Stack<Integer> st = new Stack<>();
        // Push max val to eliminated edge case 
        //  where st is empty after pop
        st.push(Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; ++i) {
            while (arr[i] >= st.peek()) {
                int temp = st.pop();
                minSum += temp * Math.min(st.peek(), arr[i]);
            }
            st.push(arr[i]);
        }
        while (st.size() > 2) {
            minSum += st.pop() * st.peek();
        }
        return minSum;
    }
    */
    
    // Botton-up DP
    // Time: O(n^3)
    // Space: O(n^2)
    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        String[][] res = new String[len][len];
        // i is the idx of the end element in array
        for (int i = 0; i < len; ++i) {
            // j is the length of subarray - 1 (for consistancy to idx)
            for (int j = 0; j <= i; ++j) {
                // Base case length = 1
                if (j == 0) {
                    res[i][j] = 0 + "," + arr[i];
                } else {
                    String[] res1 = res[i-1][j-1].split(",");
                    String[] res2 = res[i][j-1].split(",");
                    int maxLeaf = Math.max(Integer.valueOf(res1[1]), 
                                           Integer.valueOf(res2[1]));
                    int minSum = Integer.MAX_VALUE;
                    // There are j ways to split array into two halves
                    for (int k = 0; k < j; ++k) {
                        res1 = res[k+i-j][k].split(",");
                        res2 = res[i][j-k-1].split(",");
                        minSum = Math.min(minSum, 
                                          Integer.valueOf(res1[1]) * Integer.valueOf(res2[1]) + 
                                          Integer.valueOf(res1[0]) + Integer.valueOf(res2[0]));
                    }
                    res[i][j] = minSum + "," + maxLeaf;
                    
                }
            }   
        }
        String[] val = res[len-1][len-1].split(",");
        return Integer.valueOf(val[0]);
    }
    
    // DP: overlapping sub problems!
    // Top-down DP with memo, otherwise there would be TLE
    // Time: O(n^3)
    // Space: O(n^2)
    /*
    private Map<String, int[]> memo = new HashMap<>();
    
    public int mctFromLeafValues(int[] arr) {
        int[] res = helper(arr);
        return res[0];
    }
    
    private int[] helper(int[] arr) {
        String str = arr2Str(arr);
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        int len = arr.length;
        if (len == 1) {
            int[] res = new int[]{0, arr[0]};
            memo.put(str, res);
            return res;
        }
        int maxLeaf = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i < len; ++i) {
            int[] arr1 = Arrays.copyOfRange(arr, 0, i);
            int[] arr2 = Arrays.copyOfRange(arr, i, len);
            int[] res1 = helper(arr1);
            int[] res2 = helper(arr2);
            maxLeaf = Math.max(res1[1], res2[1]);
            int curSum = res1[0] + res2[0] + res1[1] * res2[1];
            minSum = Math.min(minSum, curSum);
        }
        int[] res = new int[]{minSum, maxLeaf};
        memo.put(str, res);
        return res;
    }
    private String arr2Str(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i + ",");
        }
        return sb.toString();
    }
    */
}