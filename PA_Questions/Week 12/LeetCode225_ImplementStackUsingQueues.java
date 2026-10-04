import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225_ImplementStackUsingQueues {
    static class MyStack {
        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top()); // 2
        System.out.println("Pop: " + stack.pop()); // 2
        System.out.println("Empty: " + stack.empty()); // false
    }
}
