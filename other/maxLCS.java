class Result {

    /*
     * Complete the 'maxLCS' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int maxLCS(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] leftCnt = new int[26];
        int[] rightCnt = new int[26];
        for (int i = 0; i < len; ++i) {
            rightCnt[arr[i]-'a']++;
        }

        
        int res = 0;
        for (int i = 0; i < len-1; ++i) {
            int cur = 0;
            int idx = arr[i]-'a';
            leftCnt[idx]++;
            rightCnt[idx]--;

            for (int j = 0; j < 26; ++j) {
                cur += Math.min(leftCnt[j], rightCnt[j]);
            }
            res = Math.max(res, cur);
        }

        return res;

    }

}