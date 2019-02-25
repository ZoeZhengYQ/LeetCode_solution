public class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        
        char[] arr = s.toCharArray();
        
        // first reverse whole String
        reverse(arr, 0, arr.length - 1);
        
        // then reverse words
        int l = 0;
        int r = 0;
        
        while (l < arr.length && r < arr.length) {
            while (arr[l] == ' ') { 
                l++; // now l is the first letter of the word
            }
            r = l;
            while (arr[r] != ' ') {
                r++;
                if (r == arr.length) break;
            }
            reverse(arr, l, r - 1);
            l = r;
        }
        return new String(arr);
        
        
    }
    
    private void swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    private void reverse(char[]arr, int x, int y) {
        while (x < y) { 
            swap(arr, x++, y--); 
        }
    }
}