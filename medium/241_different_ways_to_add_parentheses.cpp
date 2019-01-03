class Solution {
public:
    // recursive
    // divide into 2 part! and recursively solve them
    vector<int> diffWaysToCompute(string input) {
        vector<int> res;
        int len = input.size();
        vector<int> res1;
        vector<int> res2;
        
        for (int i = 0; i < len; ++i) {
            char curr = input[i];
            if (curr == '+' || curr == '-' || curr == '*') {
                res1 = diffWaysToCompute(input.substr(0, i));
                res2 = diffWaysToCompute(input.substr(i + 1));
            }
            for (int r1 : res1) {
                for (int r2 : res2) {
                    switch(curr) {
                        case '+' : res.push_back(r1 + r2); break;
                        case '-' : res.push_back(r1 - r2); break;
                        case '*' : res.push_back(r1 * r2); break;
                    }
                }
            }
        }
        
        if (res.empty()) { 
            res.push_back(stoi(input));
        }
        return res;
    }
};