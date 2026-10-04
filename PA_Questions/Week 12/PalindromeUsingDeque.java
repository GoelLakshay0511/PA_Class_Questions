import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeUsingDeque {
    public static boolean isPalindrome(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                deque.addLast(ch);
            }
        }

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("racecar: " + isPalindrome("racecar"));
        System.out.println("hello: " + isPalindrome("hello"));
    }
}
