class Solution {
    // longest subarray with 2 elements
    // Time: O(n)
    // Space: O(1)
    // last1 last2 is the fruit we met before current one
    // if cur == last1: 
    //      count++
    //      last2_count = 1
    //      last1 = last2, last2 = cur
    // if cur = last2
    //      count++
    //      last2_count++
    // if cur != last1 && cur != last2
    //      count = last2_count + 1
    //      last1 = last2, last2 = cur
    // also maintain a res = max(res, count)
    
    public int totalFruit(int[] tree) {
        int last1 = 0;
        int last2 = 0;
        int last2_cnt = 0;
        int cnt = 0;
        int res = 0;
        for (int fruit : tree) {
            // need to check last2 before last1!!
            // because initially they are both 0!
            if (fruit == last2) {
                cnt++;
                last2_cnt++;
            } 
            else if (fruit == last1) {
                cnt++;
                last2_cnt = 1;
                last1 = last2;
                last2 = fruit;
            }
            else {
                cnt = last2_cnt + 1;
                last2_cnt = 1;
                last1 = last2;
                last2 = fruit;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
    
    
    // a more elegant version
    /*
    public int totalFruit(int[] tree) {
        int last1 = 0, last2 = 0, last2_cnt = 0, cnt = 0, res = 0;
        for (int fruit : tree) {
            cnt = (fruit == last1 || fruit == last2) ? cnt+1 : last2_cnt + 1;
            last2_cnt = (fruit == last2) ? last2_cnt+1 : 1;
            if (fruit != last2) {
                last1 = last2;
                last2 = fruit;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
    */
}