import java.util.ArrayDeque;
import java.util.Deque;

public class AssessmentQ4_DequePalindromeChecker {
    public static boolean checkPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                deque.addLast(Character.toLowerCase(c));
            }
        }

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("A man a plan a canal Panama: " + checkPalindrome("A man a plan a canal Panama"));
        System.out.println("Hello World: " + checkPalindrome("Hello World"));
    }
}
