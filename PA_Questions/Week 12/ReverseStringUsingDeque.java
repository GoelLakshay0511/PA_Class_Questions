import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseStringUsingDeque {
    public static String reverseString(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            deque.addLast(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Reversed: " + reverseString("datastructures"));
    }
}
