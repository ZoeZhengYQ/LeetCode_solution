class Solution {
    // Time: O(n logk)
    // Space: O(k)
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
        return b.compareTo(a);
    });
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new double[0];
        double[] res = new double[nums.length - k + 1];
        int i = 0;
        for (; i < k-1; ++i) {
            if (i % 2 == 0) { // even
                minHeap.offer(nums[i]);
                maxHeap.offer(minHeap.poll());
            } else { // odd
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
            }
        }
        
        int idx = 0;
        if (k % 2 == 0) {
            for (; i < nums.length; ++i) {
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
                res[idx] = ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
                int toRemove = nums[i-k+1];
                // Need to remove a element from minHeap
                if ((double)toRemove > res[idx]) {
                    minHeap.remove(toRemove);
                } else {
                    maxHeap.remove(toRemove);
                    maxHeap.offer(minHeap.poll());
                }
                idx++;
            }    
        } else {
            for (; i < nums.length; ++i) {
                minHeap.offer(nums[i]);
                maxHeap.offer(minHeap.poll());
                res[idx] = (double)(maxHeap.peek());
                int toRemove = nums[i-k+1];
                if ((double)toRemove > res[idx]) {
                    minHeap.remove(toRemove);
                    minHeap.offer(maxHeap.poll());
                } else {
                    maxHeap.remove(toRemove);
                }
                idx++;
            }
        }
        return res;
    }
    
    private void printPQ() {
        System.out.println("minHeap: ");
        for (int min : minHeap) {
            System.out.print(min + " ");
        }
        System.out.println("");
        System.out.println("maxHeap: ");
        for (int max : maxHeap) {
            System.out.print(max + " ");
        }
        System.out.println("\n-----------------");
    }
}