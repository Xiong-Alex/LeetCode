class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        // If empty, add
        if(minStack.isEmpty()) {
            minStack.push(val);
        // Update latest min within Stack
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }
    
    // pop
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    // peek
    public int top() {
        return stack.peek();
    }
    
    // peek min
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/////////////////////////////////////
// NOTES

// Utillize 2nd stack to track Minimum at each Depth
// Stack - Last In First Out
// --- due to data structure properties, we're building from the bottom up
// --- we can determine the minimum up to that point
// --- When a new min depth comes, everything from there and above gets updated to a new depth
// --- however, everything below remains the same
// --- higher depth min, doesnt affect lower depth. 