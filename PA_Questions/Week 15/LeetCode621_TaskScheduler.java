import java.util.Arrays;

public class LeetCode621_TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char t : tasks) {
            frequencies[t - 'A']++;
        }

        Arrays.sort(frequencies);
        int maxFreq = frequencies[25];
        int idleSlots = (maxFreq - 1) * n;

        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            idleSlots -= Math.min(maxFreq - 1, frequencies[i]);
        }

        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println("Intervals: " + leastInterval(tasks, 2)); // 8
    }
}
