// 双栈解法
class MinStack {
    // 存放具体数值的栈
    private Stack<Integer> dataStack;
    // 存放栈的最小元素
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x) {
        if (minStack.isEmpty()||x <= minStack.peek()) {
            minStack.push(x);
        }
        dataStack.push(x);
    }
    public void pop() {
        if (dataStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        dataStack.pop();
    }
    public int top() {
        return dataStack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}
// 单栈解法
使用一个栈既要存放数据又要知道当前栈的最小值
元素A:具体的数据
元素B:最小值
class MinStack {
    private Stack<Integer> stack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }
    // -2 0 -3
    // -2 -2 0 -2 -3 -3
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        }else {
            int temp = stack.peek();
            stack.push(x);
            if (x < temp) {
                stack.push(x);
            }else {
                stack.push(temp);
            }
        }
    }
    public void pop() {
        stack.pop();
        stack.pop();
    }
    public int top() {
        int temp = stack.pop();
        int result = stack.peek();
        stack.push(temp);
        return result;
    }
    public int getMin() {
        return stack.peek();
    }
}






