// Runtime: 0 ms, 100.00% 
// Memory Usage: 33.5 MB, 100.00%
// Compare from the back, compare every valid character

class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] SArr = S.toCharArray();
        char[] TArr = T.toCharArray();
        
        int i = SArr.length - 1;
        int j = TArr.length - 1;
        
        while (i >= 0 && j >= 0) {
            i = charBeforeBackspace(SArr, i);
            j = charBeforeBackspace(TArr, j);
            
            if (i < 0 || j < 0) break;
            if (SArr[i] != TArr[j]) {
                return false;
            }
            i--;
            j--;
        }
        
        if (i >= 0) {
            return charBeforeBackspace(SArr, i) < 0;
        }
        if (j >= 0) {
            return charBeforeBackspace(TArr, j) < 0;
        }
        return true;
    }
    
    private int charBeforeBackspace(char[] arr, int pos) {
        int count = 0;
        while (pos >=0 && arr[pos] == '#') {
            count++;
            pos--;
        }
        
        // 记得排除掉当前字符还是#的情况！不仅仅是count > 0
        while (pos >= 0 && (count > 0 || arr[pos] == '#')) {
            if (arr[pos] == '#') {
                count++;
            } else {
                count--;
            }
            pos--;
        }
        return pos;
    }
}