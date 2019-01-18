class Solution {
public:
    // DP solution
    // Time: O(n^2)
    // Space: O(n)
    // F(i, n) = G(i-1) * G(n-i)
    
    int numTrees(int n) {
        vector<int> G (2, 1);
        for (int i = 2; i <= n; ++i) {
            int t = 0;
            for (int j = 1; j <= i; ++j) {
                t += G[j - 1] * G[i - j];
            }
            G.push_back(t);
        }
        return G[n];
    }
    
    // Math solution
    // Catalan Number
    // C_0 = 1; C_{n+1} = (2(2n+1)/(n+2)) * C_n
    /*
    int numTrees(int n) {
        double C = 1;
        for (int i = 0; i < n; ++i) {
            // remember to add "double" 
            // or it would give wrong answer!
            C *= (double)(4 * i + 2) / (i + 2);
            
        }
        return C;
    }
    */
};

