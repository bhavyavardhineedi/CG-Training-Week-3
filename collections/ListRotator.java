import java.util.*;

public class ListRotator {

    // Method to rotate a list by 'positions' to the left
    public static <T> List<T> rotateLeft(List<T> list, int positions) {
        int size = list.size();
        if (size == 0 || positions % size == 0) return list;

        positions = positions % size; // Handle rotations > size

        List<T> rotated = new ArrayList<>();

        // Add elements from 'positions' to end
        rotated.addAll(list.subList(positions, size));
        // Then add from start to 'positions'
        rotated.addAll(list.subList(0, positions));

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> result = rotateLeft(input, rotateBy);

        System.out.println("Original List: " + input);
        System.out.println("Rotated List: " + result);
    }
}
