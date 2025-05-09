import java.util.*;

public class SetSubsetChecker {

    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1); // Check if set2 contains all elements of set1
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        boolean result = isSubset(set1, set2);

        System.out.println("Is Set1 a subset of Set2? " + result);
    }
}
