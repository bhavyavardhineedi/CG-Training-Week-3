import java.util.*;

public class SetEqualityChecker {

    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 4));

        System.out.println("set1 == set2? " + areSetsEqual(set1, set2)); // true
        System.out.println("set1 == set3? " + areSetsEqual(set1, set3)); // false
    }
}
