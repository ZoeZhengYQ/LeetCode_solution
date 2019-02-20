class Solution {
    // quick sort
    // average Time: O(n)
    // worse case: O(n^2)
    public int[][] kClosest(int[][] points, int K) {
        int l = 0;
        int r = points.length - 1;
        while (l < r) {
            int mid = quickSort(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            }
            if (mid > K) {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int quickSort(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            // 先从右边开始是因为我们已经用pivot存了left，如果右边有不符合条件的点我们可以直接用left来存right
            // 不可能会丢失right，因为即使全部都比pivot大，执行下来整个pointsarray顺序不会改变
            while (l < r && compare(pivot, points[r]) <= 0) r--;
            points[l] = points[r];
            while (l < r && compare(points[l], pivot) <= 0) l++;
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }
    
    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
    /*
    // maintain a min-heap for size K
    // Time: O(n logK)
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pQ = new PriorityQueue<int[]> (K, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                // return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
                return p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1];
            }
        }
        );
        
        for (int[] p : points) {
            pQ.add(p);
            if (pQ.size() > K) {
                pQ.poll();
            }
        }
        
        // convert from priorityQueue to Array
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pQ.poll();
        }
        return res;
    }
    */
}