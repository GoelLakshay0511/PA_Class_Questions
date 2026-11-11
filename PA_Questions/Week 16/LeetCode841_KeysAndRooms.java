import java.util.*;

public class LeetCode841_KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int key : rooms.get(node)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList()
        );
        System.out.println("Can visit all: " + canVisitAllRooms(rooms)); // true
    }
}
