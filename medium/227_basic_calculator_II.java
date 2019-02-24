class Solution {
    // using preVal, sign, curVal to record states
    // Time: O(n)
    // Space: O(1)
    
    public int calculate(String s) {
        // need to be s = s.reaplaceAll(...) not s.replaceAll(...)
        s = s.replaceAll(" +", "");
        int res = 0;
        char sign = '+';
        int len = s.length();
        
        int i = 0;
        int preVal = 0;
        while (i < len) {
            int curVal = 0;
            while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                curVal = (curVal * 10) + s.charAt(i) - '0';
                i++;
            }
            if (sign == '+') {
                res += preVal;
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;
                preVal = -curVal;
            } else if (sign == '*') {
                preVal *= curVal;
            } else if (sign == '/') {
                preVal /= curVal;
            }
            if (i < len) {
                sign = s.charAt(i);
            }
            i++;
            
        }
        res += preVal;
        return res;
    }
    
    
    // solution using stack
    // Time: O(n)
    // Space: O(n)
    /*
    public int calculate(String s) {
        s = s.replaceAll(" +", "");
        
        int i = 0;
        int res = 0;
        char sign = '+';
        int len = s.length();
        Stack<Integer> st = new Stack<>();
        
        
        while (i < len) {
            int val = 0;
            while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                val = val * 10 + s.charAt(i) - '0';
                i++;
            }
            if (sign == '+') { st.push(val); }
            else if (sign == '-') { st.push(-val); }
            else if (sign == '*') { st.push(st.pop() * val); }
            else if (sign == '/') { st.push(st.pop() / val); }
            if (i < len) {
                sign = s.charAt(i);
            }
            i++;
        }
        
        for (int v : st) {
            res += v;
            System.out.println(v);
        }
        return res;
    }
    */
    
}