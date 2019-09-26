class MinStack {
    // Find min in O(1) time!
    private Stack<Integer> minSt;
    private Stack<Integer> valSt;
    
    /** initialize your data structure here. */
    public MinStack() {
        minSt = new Stack<>();
        valSt = new Stack<>();
        minSt.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        // 注意是小于等于，因为有可能有重复的min，如2,0,3,0
        if (x <= minSt.peek()) {
            minSt.push(x);
        }
        valSt.push(x);
    }
    
    public void pop() {
        int val = valSt.pop();
        if (val == minSt.peek()) {
            minSt.pop();
        }
    }
    
    public int top() {
        return valSt.peek();
    }
    
    public int getMin() {
        return minSt.size() > 1 ? minSt.peek() : 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */