class Solution {
public:
    // Kadane's Algorithm
    // 这种求一个array里面差值最大的方法就是相邻两个相加！
    // Time: O(n)
    // Space: O(1)
    int maxProfit(vector<int>& prices) {
        int curMaxPro = 0;
        int MaxPro = 0;
        
        for (int i = 1; i < prices.size(); ++i) {
            curMaxPro = max(0, curMaxPro += prices[i] - prices[i - 1]);
            MaxPro = max(curMaxPro, MaxPro);
            cout << "cur: " << curMaxPro << ", max: " << MaxPro << endl;
        }
        return MaxPro;
    }
};