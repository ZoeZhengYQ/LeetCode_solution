class Solution {
public:
    // using unordered map to count!!
    // Time: O(n)
    // Space: O(n)
    // 16ms, 38.04%
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;
        unordered_map<char, int> cnt;
        for (int i = 0; i < s.size(); ++i) {
            cnt[s[i]]++;
            cnt[t[i]]--;
        }
        for (auto a : cnt) {
            if (a.second) return false;
        }
        return true;
    }
    
    // sorting
    // Time: O(n logn)
    // Space: O(1)
    /*
    bool isAnagram(string s, string t) {
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        return s == t;
    }
    */
};