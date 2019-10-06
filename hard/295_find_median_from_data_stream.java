class MedianFinder {
    // Two heap to keep track of median
    // Find: O(1)
    // Add: O(log n)
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private boolean isEven;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<>();
        isEven = true;
    }
    
    public void addNum(int num) {
        if (isEven) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        // Remember the 2.0 here!!
        return isEven ? (maxHeap.peek() + minHeap.peek()) / 2.0 : minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */