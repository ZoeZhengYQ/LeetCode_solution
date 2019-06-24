class Solution {
    // Iteration: FIFO Queue
    // Time: O(n)
    // Space: O(n)
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) return res;
        String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", 
                                    "pqrs", "tuv", "wxyz"};
        res.add("");
        int len = digits.length();
        while (res.peek().length() != len) {
            String part = res.remove();
            String str = map[digits.charAt(part.length()) - '0'];
            for (char c : str.toCharArray()) {
                res.addLast(part+c);
            }
        }
        return res;
    }
}