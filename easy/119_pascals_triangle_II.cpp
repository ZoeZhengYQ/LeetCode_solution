class Solution {
public:
    // using a prev and next integers to rememer values needed to perform adding
    vector<int> getRow(int rowIndex) {
        vector<int> res(1, 1);
        if (rowIndex == 0) return res;
        for (int i = 1; i <= rowIndex; ++i) {
            res.push_back(1);
            int prev = res[0];
            int next = res[1];
            for (int j = 1; j <= i / 2; ++j) {
                res[j] = res[i - j] = prev + next;
                prev = next;
                next = res[j + 1];
            }
        }
        return res;
    }
};