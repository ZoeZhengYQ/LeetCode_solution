class Solution {
    // Use stack to remove adjacent duplicates
    // Time: O(n)
    // Space: O(n)
    class Data {
        char c;
        int num;
        
        Data(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        int len = s.length();
        if (len == 1) return s;
        
        char[] sArr = s.toCharArray();
        Stack<Data> st = new Stack<>();
        for (char c : sArr) {
            if (!st.isEmpty()) {
                Data top = st.peek();
                if (top.c == c) {
                    top.num++;
                    if (top.num == k) {
                        st.pop();
                    }
                } else {
                    st.push(new Data(c, 1));
                }
            } else {
                st.push(new Data(c, 1));
            }
        }
        
        Stack<Data> rev = new Stack<>();
        while (!st.isEmpty()) {
            rev.push(st.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        while (!rev.isEmpty()) {
            Data d = rev.pop();
            for (int i = 0; i < d.num; ++i) {
                sb.append(d.c);
            }
        }
        return sb.toString();
    }
}