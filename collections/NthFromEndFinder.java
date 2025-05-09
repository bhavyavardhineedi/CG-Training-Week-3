import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEndFinder {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0) throw new IllegalArgumentException("Invalid input");

        ListIterator<T> fast = list.listIterator();
        ListIterator<T> slow = list.listIterator();

        // Move fast pointer n steps ahead
        int steps = 0;
        while (fast.hasNext() && steps < n) {
            fast.next();
            steps++;
        }

        if (steps < n) throw new IllegalArgumentException("N is larger than the list size");

        // Move both pointers until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // slow now points to the Nth from end
        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        try {
            String result = findNthFromEnd(list, N);
            System.out.println("Nth element from end (" + N + "): " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
