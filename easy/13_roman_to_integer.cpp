class Solution {
public:
    // Brief solution using unordered map
    // search from the back to make cases simple!
    int romanToInt(string s) {
        unordered_map<char, int> romToInt = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, 
                                             {'C', 100}, {'D', 500}, {'M', 1000}};
        int res = romToInt[s.back()];
        for (int i = s.size() - 2; i >= 0; --i) {
            if (romToInt[s[i]] < romToInt[s[i + 1]]) {
                res -= romToInt[s[i]];
            }
            else res += romToInt[s[i]];
        }
        return res;
    }
    
    // naive solution
    // 108ms, 12.49%
    // Time: O(n)
    /*
    int romanToInt(string s) {
        int i = 0;
        int result = 0;
        while(i < s.size()) {
            if (s[i] == 'I') {
                if (i + 1 < s.size()) {
                    if (s[i + 1] == 'V') {
                        result += 4;
                        i += 2;
                        continue;
                    }
                    else if (s[i + 1] == 'X') {
                        result += 9;
                        i += 2;
                        continue;
                    }
                    result += 1;
                }
                else {
                    result += 1;
                    break;
                }
            }
            
            else if (s[i] == 'V') {
                result += 5;
            }
            
            else if (s[i] == 'X') {
                if (i + 1 < s.size()) {
                    if (s[i + 1] == 'L') {
                        result += 40;
                        i += 2;
                        continue;
                    }
                    else if (s[i + 1] == 'C') {
                        result += 90;
                        i += 2;
                        continue;
                    }
                    result += 10;
                }
                else {
                    result += 10;
                    break;
                }
            }
            
            else if (s[i] == 'L') {
                result += 50;
            }
            
            else if (s[i] == 'C') {
                if (i + 1 < s.size()) {
                    if (s[i + 1] == 'D') {
                        result += 400;
                        i += 2;
                        continue;
                    }
                    else if (s[i + 1] == 'M') {
                        result += 900;
                        i += 2;
                        continue;
                    }
                    result += 100;
                }
                else {
                    result += 100;
                    break;
                }
            }
            
            else if (s[i] == 'D') {
                result += 500;
            }
            else if (s[i] == 'M') {
                result += 1000;
            }
            else { return -1; }
            i++;
        }
        return result;
    }
    */
};