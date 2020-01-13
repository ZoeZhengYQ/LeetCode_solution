class MedianFinder {
    // Two heap to keep track of median
    // Find: O(1)
    // Add: O(log n)
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    // Neater to use a boolean value here
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

    /*
    private int size;
    // The right half
    private PriorityQueue<Integer> minHeap;
    // The left half
    private PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        this.size = 0;
        // Default is a maxHeap
        this.maxHeap = new PriorityQueue<>();
        this.minHeap = new PriorityQueue<>((a, b) -> {
            return b.compareTo(a);
        });
    }
    
    // Time: O(1)
    public void addNum(int num) {
        if (size % 2 == 0) { // even -> odd
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else { // odd -> even
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        size++;
    }
    
    // Time: O(log n)
    public double findMedian() {
        if (size % 2 == 0) {
            int l = maxHeap.peek(), r = minHeap.peek();
            return (double)(l+r) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
    */
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */