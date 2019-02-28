class Solution {
    public int sumSubarrayMins(int[] A) {
        int len = A.length;
        Stack<Integer> st = new Stack<>();
        Integer[] left = new Integer[len];
        Integer[] right = new Integer[len];
        
        int res = 0;
        int mod = (int)1e9 + 7;
        
        for (int i = 0; i < len; ++i) {
            left[i] = i + 1;
            right[i] = len - i;
        }
        
        // prev less
        for (int i = 0; i < len; ++i) {
            while (!st.isEmpty() && A[st.peek()] > A[i]) {
                st.pop();
            }
            
            left[i] = (st.isEmpty()) ? i + 1 : i - st.peek();
            st.push(i);
        }
        
        // next less
        st = new Stack<>();
        for (int i = 0; i < len; ++i) {
            while (!st.isEmpty() && A[st.peek()] > A[i]) {
                int tmp = st.pop();
                right[tmp] = i - tmp;
            }
            st.push(i);
        }
        
        // System.out.println(Arrays.deepToString(left));
        // System.out.println(Arrays.deepToString(right));
        
        for (int i = 0; i < len; ++i) {
            res = (res + A[i] * left[i] * right[i]) % mod;
        }
        
        return res;
    }
}