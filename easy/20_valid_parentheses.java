class Solution {
    // Stack solution
    // Time: O(n)
    // Space: O(n)
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                st.push(c);
            } else {
                if (st.isEmpty() || map.get(c) != st.peek()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty() ? true : false;
    }
}