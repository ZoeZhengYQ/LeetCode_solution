// There is a heap of stones on the table
// each time one of you take turns to remove 1 to 3 stones. 
// The one who removes the last stone will be the winner. 
// You will take the first turn to remove the stones.

class Solution {
public:
    // can win the game if the number of stone is NOT divisible by 4
    bool canWinNim(int n) {
        return ((n % 4) != 0);
    }
};