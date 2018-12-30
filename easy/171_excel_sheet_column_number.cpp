class Solution {
public:
    // could calculate from left to right this way!
    // avoid using pow() in every iteration
    int titleToNumber(string s) {
        int res = 0;
        for(int i = 0; i < s.length(); ++i){
            res *= 26;
            res += s[i] - 'A' + 1;
        }
        return res;
    }
    
    // using pow() in each iteration could be slow
    /*
    int titleToNumber(string s) {
        int n = s.size() - 1;
        int res = 0;
        for (int i = n; i >= 0; --i) {
            int w = s[i] - 'A' + 1;
            res += w * pow(26, n - i);
        }
        return res;
    }
    */
};