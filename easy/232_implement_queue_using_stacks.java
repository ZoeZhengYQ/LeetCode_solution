// using two Stack to implement queue
class MyQueue {
    Stack<Integer> inputS;
    Stack<Integer> outputS;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        inputS = new Stack<>();
        outputS = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inputS.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outputS.empty()) {
            while (!inputS.empty()) {
                int tmp = inputS.pop();
                outputS.push(tmp);
            }
        }
        if (outputS.empty()) 
            return 0;
        return outputS.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        int peek = pop();
        outputS.push(peek);
        return peek;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputS.empty() && outputS.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */