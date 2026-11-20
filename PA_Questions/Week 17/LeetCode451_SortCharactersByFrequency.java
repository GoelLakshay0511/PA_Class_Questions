import java.util.*;

public class LeetCode451_SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(freqMap.get(b), freqMap.get(a))
        );
        maxHeap.addAll(freqMap.keySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int count = freqMap.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("tree -> " + frequencySort("tree"));
        System.out.println("cccaaa -> " + frequencySort("cccaaa"));
    }
}
