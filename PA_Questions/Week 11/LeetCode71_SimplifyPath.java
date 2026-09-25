import java.util.Deque;
import java.util.LinkedList;

public class LeetCode71_SimplifyPath {
    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");

        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.addLast(directory);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        System.out.println("Path: " + simplifyPath("/home//foo/")); // /home/foo
        System.out.println("Path: " + simplifyPath("/../"));         // /
    }
}
