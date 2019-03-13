class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        // starting from the tail
        for (int i = S.length() - 1; i >= 0; --i) {
            // do nothing if -
            if (S.charAt(i) == '-') continue;
            // if is alphabet
            else {
                // if it is not the start of the result
                // and if it has already K in length
                if (cnt == 0 && sb.length() != 0) {
                    sb.append("-");
                }
                sb.append(S.charAt(i));
            }
            // loop for every K to count
            cnt = (++cnt) % K;
        }
        return sb.reverse().toString().toUpperCase();
    }
    
    
    // a more concise solution
    /*
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append((sb.length() % (K+1)) == K ? '-' : "").append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
    */
}