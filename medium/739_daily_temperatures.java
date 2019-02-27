class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;
        
        int len = T.length;
        int[] res = new int[len]; 
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; ++i) {
            while (!st.isEmpty() && T[i] > T[st.peek()]) {
                int idx = st.pop();
                res[idx] = i - idx;
            }
            st.push(i);
        }
        return res;
    }
        
}