class Result {

    /*
     * Complete the 'gridGame' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY grid
     *  2. INTEGER k
     *  3. STRING_ARRAY rules
     */

    public static List<List<Integer>> gridGame(List<List<Integer>> grid, int k, List<String> rules) {
        int xLen = grid.size();
        int yLen = grid.get(0).size();
        int[][] count = new int[xLen][yLen];

        int idx = 0;
        boolean[] rulesArr = new boolean[9];
        for (String rule : rules) {
            if (rule.startsWith("a")) {
                rulesArr[idx] = true;
            } else {
                rulesArr[idx] = false;
            }
            idx++;
        }

        int[] xDis = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] yDis = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (k > 0) {
            for (int i = 0; i < xLen; ++i) {
                for (int j = 0; j < yLen; ++j) {
                    int cnt = 0;
                    for (int m = 0; m < 8; ++m) {
                        int curX = i + xDis[m];
                        int curY = j + yDis[m];
                        if (curX < 0 || curX > xLen-1 || curY < 0 || curY > yLen-1) {
                            continue;
                        }
                        cnt += grid.get(curX).get(curY);
                    }
                    count[i][j] = cnt;
                }
            }

            for (int i = 0; i < xLen; ++i) {
                for (int j = 0; j < yLen; ++j) {
                    int status = rulesArr[count[i][j]] ? 1: 0;
                    grid.get(i).set(j, status);
                }
            }

            k--;
        }
        return grid;
    }