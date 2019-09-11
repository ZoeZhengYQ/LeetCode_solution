class Solution {
    // DP solotion
    // Time: O(TlogT)
    // Space: O(T)
    public int racecar(int target) {
        if (target == 0) return 0;
        // 1 <= target <= 10000
        int[] dp = new int[target+1];
        return helper(target, dp);
    }
    
    private int helper(int t, int[] dp) {
        if (dp[t] > 0) return dp[t];
        
        int n = (int)(Math.log(t) / Math.log(2)) + 1;
        
        // Exactly i==2^n-1, n steps
        if (1 << n == t + 1) dp[t] = n;
        else {
            // use n A to arrive at 2^(n-1) then R to reverse
            dp[t] = helper((1 << n) - 1 - t, dp) + n + 1;
            // Use n-1 A to arrive at 2^(n-1)-1 first, 
            // then R to change the direction, use m A to go backward, 
            // then use R to change the direction again to move forward, 
            // by here there are n-1+2+m=n+m+1 operations (n-1 A, two R, m A) , 
            // current position is 2^(n-1)-1-(2^m-1)=2^(n-1)-2^m, 
            // the remaining operations is same as dp[i-(2^(n-1)-1)+(2^m-1)]=dp[i-2^(n-1)+2^m)]
            for (int m = 0; m < n - 1; ++m)
                dp[t] = Math.min(dp[t], helper(t - (1 << (n - 1)) + (1 << m), dp) + n + m + 1);
        }
        return dp[t];
    }
    
    // Find shortest path: BFS
    // Time Complexity: O(TlogT)
    // There are O(T) nodes, we process each one using O(logT) work 
    // (both popping from the heap and adding the edges).
    // Space Complexity: O(T).
    /*
    public int racecar(int target) {
        int steps = 0;
        String begin = buildStr(0, 1);
        
        Set<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>(); 
 
        visited.add(begin);
        queue.add(begin);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String[] info = queue.poll().split(",");
                int curPos = Integer.valueOf(info[0]);
                int curSpeed = Integer.valueOf(info[1]);
                
                if (curPos == target) { return steps; }
                // Case "A"
                int newPos = curPos + curSpeed;
                int newSpeed = curSpeed * 2;
                String newStr = buildStr(newPos, newSpeed);
                if (!visited.contains(newStr) && Math.abs(newPos - target) < Math.abs(target)) {
                    visited.add(newStr);
                    queue.add(newStr);
                }
                // Case "R"
                newPos = curPos;
                newSpeed = curSpeed > 0 ? -1 : 1;
                newStr = buildStr(newPos, newSpeed);
                if (!visited.contains(newStr) && Math.abs(newPos - target) < Math.abs(target)) {
                    visited.add(newStr);
                    queue.add(newStr);
                }
            }
            steps++;
        }
        return -1;
    }
    
    private String buildStr(int pos, int speed) {
        return pos + "," + speed;
    }
    */
}