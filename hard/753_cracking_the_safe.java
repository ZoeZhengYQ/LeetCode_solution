class Solution {
    // 暴力DFS解法
    // Node1 -> Node2: node1前n-1位加一位0到k-1的char
    // Set存visited
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) 
            sb.append('0');
        int targetNum = (int)Math.pow(k, n);
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        
        DFSHelper(sb, visited, targetNum, n, k);
        
        return sb.toString();
    }
    
    private boolean DFSHelper(StringBuilder sb, Set<String> visited, int targetNum, int n, int k) {
        if (visited.size() == targetNum)
            return true;
        
        String tailDigits = sb.substring(sb.length() - n + 1); 
        for (char c = '0'; c < '0' + k; ++c) {
            String newComb = tailDigits + c;
            if (!visited.contains(newComb)) {
                sb.append(c);
                visited.add(newComb);
                if (DFSHelper(sb, visited, targetNum, n, k)) {
                    return true;
                }
                visited.remove(newComb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}