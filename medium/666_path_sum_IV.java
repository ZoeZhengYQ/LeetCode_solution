class Solution {
    // 1D array to represent path sum
    // Key: 
    // 1) level is smaller than 5
    // 2) array is given ascending
    // Time: O(n)
    // Space: O(1)
    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        // Level of tree
        int level =  nums[nums.length-1]/100;
        // max number of path: 1<<(level-1)
        int[] res = new int[1<<(level-1)];
        Arrays.fill(res, -1);
        
        // count from tail
        for (int i = nums.length-1; i >= 0; --i) {
            int cur = nums[i], curL = nums[i]/100;
            int curP = nums[i]%100/10, curV = nums[i]%10;
            
            if (curL == level) {
                res[curP-1] = curV;
            } else {    // upper level of tree
                int total = 1 << (level-curL);  // number of child of this node
                int start = (curP-1)*total;     // start idx in res array
                boolean isLeaf = true;
                // if all child path sum is -1, then this node is leaf
                for (int j = start; j < start+total; ++j) {
                    if (res[j] != -1) {
                        res[j] += curV;
                        isLeaf = false;
                    }
                }
                // add the node to res path
                if (isLeaf) {
                    res[start] = curV;
                }
            }
        }
        int sum = 0;
        // only sum up path sum that's not -1
        for (int i : res) {
            sum += (i == -1) ? 0 : i;
        }
        return sum;
    }
}