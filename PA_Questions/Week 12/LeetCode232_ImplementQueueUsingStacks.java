import java.util.Stack;

public class LeetCode232_ImplementQueueUsingStacks {
    static class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            shiftStacks();
            return outStack.pop();
        }

        public int peek() {
            shiftStacks();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void shiftStacks() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println("Peek: " + q.peek()); // 1
        System.out.println("Pop: " + q.pop());   // 1
        System.out.println("Empty: " + q.empty()); // false
    }
}
