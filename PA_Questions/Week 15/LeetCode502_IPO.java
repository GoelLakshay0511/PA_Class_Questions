import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode502_IPO {
    static class Project {
        int capital;
        int profit;
        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        // Sort projects by required capital
        Arrays.sort(projects, (a, b) -> Integer.compare(a.capital, b.capital));

        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        int projectIndex = 0;

        for (int i = 0; i < k; i++) {
            while (projectIndex < n && projects[projectIndex].capital <= w) {
                maxProfitHeap.add(projects[projectIndex].profit);
                projectIndex++;
            }

            if (maxProfitHeap.isEmpty()) break;

            w += maxProfitHeap.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println("Max Capital: " + findMaximizedCapital(2, 0, profits, capital)); // 4
    }
}
