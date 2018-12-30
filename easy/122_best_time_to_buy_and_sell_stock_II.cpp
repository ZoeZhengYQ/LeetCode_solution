class Solution {
public:
    // more brief solution
    int maxProfit(vector<int>& prices) {
        if (prices.size() < 2) { return 0; }
        int pro = 0;
        for (int i = 1; i < prices.size(); ++i) {
            // if there is ascending price, add it to profit
            pro += max(0, prices[i] - prices[i - 1]);
        }
        return pro;
    }
    
    // original naive solution
    /*
    int maxProfit(vector<int>& prices) {
        if (prices.size() < 2) { return 0; }
        int l = (prices[0] < prices[1] ? 0 : 1);
        int h = l;
        int pro = 0;
        while (l < prices.size() - 1 && h < prices.size()) {
            while (prices[l] > prices[l + 1]) {
                l++;
            }
            h = l + 1;
            // cout << "Low: " << l << endl;
            if (l == prices.size() - 1) { break; }
            while (prices[h] < prices[h + 1] && h < prices.size() - 1) {
                h++;
            }
            // cout << "High: " << h << endl;
            if (h > l && h < prices.size()) { pro += (prices[h] - prices[l]); }
            l = h + 1;
        }
        return pro;
    }
    */
};