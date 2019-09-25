class Solution {
    private int[] range;
    private Random rand;

    public Solution(int[] w) {
        this.rand = new Random();
        this.range = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; ++i) {
            sum += w[i];
            range[i] = sum;
        }
    }
    
    public int pickIndex() {
        int len = range.length;
        int num = rand.nextInt(range[len-1])+1; // [1, range[len-1]]
        int l = 0, r = len-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (range[mid] == num) return mid;
            else if (range[mid] < num) {
                // 因为是取上限所以是mid+1
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */