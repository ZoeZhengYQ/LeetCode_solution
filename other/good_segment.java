class Result {

    /*
     * Complete the 'goodSegment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY badNumbers
     *  2. INTEGER l
     *  3. INTEGER r
     */

    public static int goodSegment(List<Integer> badNumbers, int l, int r) {
        Collections.sort(badNumbers);

        int idx = 0;
        // Eliminate the first few bad number out of range
        while (badNumbers.get(idx) < l) {
            idx++;
        }
        
        int max = badNumbers.get(idx)-1-l;
        // Leave the last one element if all of them are not out of range
        // Or leave the last one element that is not our of range
        for (; idx < badNumbers.size()-1 && badNumbers.get(idx+1) < r; ++idx) {
            int curInterval = badNumbers.get(idx+1)-badNumbers.get(idx)-1;
            max = Math.max(max, curInterval);
        }
        
        return Math.max(max, r-badNumbers.get(idx));

    }

}

