class Solution {
public:
    int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        vector<int> store (n, 1);
        
        int p2 = 0, p3 = 0, p5 = 0;
        
        for (int i = 1; i < n; ++i) {
            int res2 = 2 * store[p2];
            int res3 = 3 * store[p3];
            int res5 = 5 * store[p5];

            // increasingly find the next ugly number
            store[i] = min(res2, min(res3, res5));
            if (store[i] == res2) p2++;
            if (store[i] == res3) p3++;
            if (store[i] == res5) p5++;
        }
        return store[n - 1];
    }
};