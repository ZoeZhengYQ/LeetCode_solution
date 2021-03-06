class Solution {

    // recursive version
    
public:
    vector<string> generateParenthesis(int n) {
        if (n == 0) return vector<string> (1, "");
        if (n == 1) return vector<string> (1, "()");
        vector<string> result;
        std::string str = "";
        add_par(result, str, n, 0);
        return result;
    }
    
private:
    void add_par(vector<string> &result, string str, int leftCnt, int rightCnt) {
        if (leftCnt == 0 && rightCnt == 0) {
            result.push_back(str);
            return;
        }
        // if there are still left par available
        // add one left, decrement left count and imcrement right count
        if (leftCnt > 0) {
            add_par(result, str + "(", leftCnt - 1, rightCnt + 1);
        }
        // if there are still right par available
        // add one right and decrement right count
        if (rightCnt > 0) {
            add_par(result, str + ")", leftCnt, rightCnt - 1);
        }
    }
    
};