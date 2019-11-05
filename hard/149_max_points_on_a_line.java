class Solution {
    // Time: O(n^2)
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        for (int i = 0; i < points.length-1; ++i) {
            int overlapCnt = 0, partialMax = 0;
            Map<String, Integer> map = new HashMap<>(); // 在这里创建map避免重复计算
            for (int j = i+1; j < points.length; ++j) {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];
                if (deltaX == 0 && deltaY == 0) {
                    overlapCnt++;
                    continue;
                }
                
                int gcd = calGCD(deltaX, deltaY);
                deltaX /= gcd;
                deltaY /= gcd;
                String slope = deltaX + "/" + deltaY; // 斜率用string表示
                int slopeCnt = map.getOrDefault(slope, 0)+1;
                map.put(slope, slopeCnt);
                partialMax = Math.max(partialMax, slopeCnt); // 当前点出发的最大数量
            }
            max = Math.max(max, overlapCnt+partialMax+1); // 最大数量+重合数量+点本身
        }
        return max;
    }
    
    // n1 > n2
    private int calGCD(int n1, int n2) {
        if (n2 == 0) return n1;
        return calGCD(n2, n1%n2);  // also help swap n1 and n2 if n1 < n2
    }
}
