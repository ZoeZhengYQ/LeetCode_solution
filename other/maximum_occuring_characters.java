class Result {

    /*
     * Complete the 'maximumOccurringCharacter' function below.
     *
     * The function is expected to return a CHARACTER.
     * The function accepts STRING text as parameter.
     */

    public static char maximumOccurringCharacter(String text) {
        // ASCII code a-z, A-Z, 0-9
        int[] count = new int[128];
        char[] charArr = text.toCharArray();
        for (char c : charArr) {
            count[c]++;
        }
        
        int max = 0;
        char res = charArr[0];
        for (char c : charArr) {
            if (count[c] > max) {
                max = count[c];
                res = c;
            }
        }
        return res;
    }

}

