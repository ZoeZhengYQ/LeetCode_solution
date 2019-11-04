class Solution {
    // Use a deque
    // Discard any "useless" element that is smaller than current element
    // so the max is always dq.peek()
    // Time: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int idx = 0;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            while (!dq.isEmpty() && dq.peek() < i-k+1) { // remove index out of the window
                dq.poll();
            }
            
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) { // remove "useless" element from tail
                // 注意是从tail删掉不是从head，
                // 例子：[6,4,5]，加入5时如果6还在范围内我们就删不掉4，
                // 一旦6出窗了我们会误以为4是max
                dq.pollLast(); 
            }
            
            dq.offer(i);
            if (i >= k-1) {
                res[idx++] = nums[dq.peek()];
            }
        }
        return res;
    }
    
    // Naive solution using priority queue
    // Time: O(nk)
    //   remove: O(k)
    //   peek: O(logk)
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int left = nums.length - k + 1;
        int[] res = new int[left];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);
        int i = 0;
        while (i < k-1) { pq.add(nums[i++]);}
        
        for (int j = 0; j < left; ++j) {
            pq.add(nums[k+j-1]);
            res[j] = pq.peek();
            pq.remove(nums[j]);
        }
        return res;
    }
    */
}