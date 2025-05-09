import java.util.*;

public class SetToSortedList {

    public static List<Integer> convertToSortedList(Set<Integer> set) {
        // Convert HashSet to List and sort it
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); // Sort the list in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList = convertToSortedList(set);

        System.out.println("Sorted List: " + sortedList);
    }
}
