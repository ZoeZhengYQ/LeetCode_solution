class Solution {
public:
    // 1-line solution using congruence formula in digital root
    // the result is periodic
    // dr(n) = 0 if n == 0
    // dr(n) = (b-1) if n != 0 and n % (b-1) == 0
    // dr(n) = n mod (b-1) if n % (b-1) != 0
    // or
    // dr(n) = 1 + (n - 1) % 9
    int addDigits(int num) {
        return 1 + (num - 1) % 9; 
    }
    
    // my solution using list
    // Space: O(n)
    /*
    int addDigits(int num) {
        if (num == 0) return 0;
        
        int dig = 0, result = 0;
        list<int> toAdd;
        while (1) {
            while (num > 0) {
                dig = num % 10;
                toAdd.push_back(dig);
                num /= 10;
            }
            result = std::accumulate(toAdd.begin(), toAdd.end(), 0);
            if (result < 10) {
                break;
            }
            else {
                num = result;
                toAdd.clear();
            }
        }
        return result;
    }
    */
};