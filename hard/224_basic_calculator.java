class Solution {
    public int calculate(String s) {
        // delete space
        s = s.replaceAll(" +", "");
        
        int res = 0;
        int val = 0;
        int sign = 1;
        int len = s.length();
        int i = 0;
        
        Stack<Integer> st = new Stack<> ();
        
        while (i < len) {
            while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                val *= 10;
                val += (s.charAt(i) - '0');
                i++;
            }
            if (i >= len) break;
            
            char c = s.charAt(i);
            if (c == '+') {
                res += sign * val;
                sign = 1;
            } else if (c == '-') {
                res += sign * val;
                sign = -1;
            } else if (c == '(') {
                // push result before the parenthesis
                st.push(res);
                // push sign before the parenthesis
                st.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign*val;
                // get sign
                res *= st.pop();
                // get previous result
                res += st.pop();
            }
            val = 0;
            i++;
        }
        res += sign*val;
        return res;
        
    }
}