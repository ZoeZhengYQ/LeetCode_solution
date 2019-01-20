class Solution {
public:
    // using linked list cycle!!
    // 4ms, 92.86%
    bool isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = digitWiseSqrtSum(slow);
            fast = digitWiseSqrtSum(digitWiseSqrtSum(fast));
        } while (slow != fast);
        if (slow == 1) return true;
        return false;
    }
    
    
    int digitWiseSqrtSum (int n) {
        string number = to_string(n);
        int res = 0;
        for (auto digit : number) {
            res += (digit - '0') * (digit - '0');
        }
        return res;
    }
    
    // naive solution
    // using vector to store all seen result
    // waste of space and time(traverse vector to find item)
    /*
    bool isHappy(int n) {
        string number = to_string(n);
        vector<int> store (1, n);
        int res = 0;
        do{
            store.push_back(res);
            res = 0;
            for (auto digit : number) {
                res += (digit - '0') * (digit - '0');
            }
            if (res == 1) return true;
            number = to_string(res);
            cout << res << endl;
        } while(find(store.begin(), store.end(), res) == store.end());
        cout << "store " << endl;
        for (auto a : store) {
            cout << a << " ";
        }
        cout << endl;
        return false;
    }
    */
};