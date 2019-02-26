class Solution {
    // starting from the pront
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Stack<String> st = new Stack<>();
        st.push(expression);
        
        while (true) {
            String str = st.pop();
            System.out.println("str: " + str);
            int l = 0, r = 0;
            char choice = str.charAt(0);

            while (str.charAt(l) != '?') { l++;}
            
            int count = 1;
            r = l;
            while (count != 0) {
                r++;
                if (str.charAt(r) == '?') {
                    count++;
                } else if (str.charAt(r) == ':') {
                    count--;
                }
            }
            
            if (choice == 'F') {
                st.push(str.substring(r+1));
            } else if (choice == 'T') {
                // substring里面第r是end是不会被push的！！
                st.push(str.substring(l+1, r));
            }
            if (st.size() == 1 && st.peek().length() == 1) 
                return String.valueOf(st.peek());
        }
    }
    
    
    // starting from the tail of the expression
    // skip ':' and push result
    // every time there is a '?', check previous character
    // if is 'T'
    // pop the second one in the stack (pop, pop, push)
    // if is 'F'
    // pop the first one in the stack
    /*
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";
        
        Stack<Character> st = new Stack<>();
        int i = expression.length() - 1;
        
        while (i >= 0) {
            char c = expression.charAt(i);
            if (c == '?') {
                i--;
                if (expression.charAt(i) == 'T') {
                    char tmp = st.pop();
                    st.pop();
                    st.push(tmp);
                } else if (expression.charAt(i) == 'F') {
                    st.pop();
                }
            }
            else if (c != ':') {
                st.push(c);
            }
            i--;
        }
        return String.valueOf(st.pop());
    }
    */
}