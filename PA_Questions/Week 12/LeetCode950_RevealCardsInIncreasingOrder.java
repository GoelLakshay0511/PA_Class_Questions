import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode950_RevealCardsInIncreasingOrder {
    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Deque<Integer> indexQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            indexQueue.addLast(i);
        }

        int[] result = new int[n];
        for (int card : deck) {
            result[indexQueue.pollFirst()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.addLast(indexQueue.pollFirst());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println("Order: " + Arrays.toString(deckRevealedIncreasing(deck)));
    }
}
