class Solution {
public:
    // solution 1:
    // feature of gray code: mirror arrangement
    
    vector<int> grayCode(int n) {
        vector<int> res (1, 0);
        for (int i = 0; i < n; ++i) {
            int size = res.size();
            for (int j = size - 1; j >= 0; --j) {
                res.push_back(res[j] | (1 << i));
            }
        }
        return res;
    }
    
    
    // solution 2:
    // direct arrangement
    /*
    vector<int> grayCode(int n) {
        vector<int> res;
        int size = pow(2, n);
        for (int i = 0; i < size; ++i) {
            res.push_back((i >> 1) ^ i);
        }
        return res;
    }
    */
};
    