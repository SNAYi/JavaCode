class MyQueue {

    Stack <Integer> stack = new Stack<Integer>();
	Stack <Integer> stackTemp = new Stack<Integer>();
	/** Initialize your data structure here. */
	public MyQueue() {
		
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		stack.push(x);
		
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {		
        if(stackTemp.empty()) {
           while(!stack.empty()){
			    stackTemp.push(stack.pop());
		    } 
        }
        int temp = 0;
        if(!stackTemp.empty()) {
            temp = stackTemp.pop();
        }
		/*
		while(!stackTemp.isEmpty()){
			stack.push(stackTemp.pop());
		}*/	
		return temp;
	}

	/** Get the front element. */
	public int peek() {
		while(!stack.empty()){
			stackTemp.push(stack.pop());
		}
		int temp = stackTemp.peek();
		while(!stackTemp.empty()){
			stack.push(stackTemp.pop());
		}		
		return temp;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stackTemp.empty() && stack.empty();
	}
}