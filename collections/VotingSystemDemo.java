import java.util.*;

class VotingSystem {
    private Map<String, Integer> votes = new HashMap<>(); // HashMap to store votes
    private LinkedHashMap<String, Integer> votesInOrder = new LinkedHashMap<>(); // LinkedHashMap to maintain insertion order
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>(); // TreeMap to sort by candidate name

    // Cast a vote for a candidate
    public void vote(String candidate) {
        // Increase the vote count in HashMap and LinkedHashMap
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        votesInOrder.put(candidate, votesInOrder.getOrDefault(candidate, 0) + 1);
        
        // Update the TreeMap with sorted votes by candidate name (TreeMap keeps keys in sorted order)
        sortedVotes.put(candidate, votesInOrder.get(candidate));
    }

    // Get total votes for a candidate
    public int getVotes(String candidate) {
        return votes.getOrDefault(candidate, 0);
    }

    // Display all votes in the order they were cast (LinkedHashMap)
    public void displayVotesInOrder() {
        System.out.println("Votes in insertion order:");
        for (Map.Entry<String, Integer> entry : votesInOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Display sorted results (TreeMap)
    public void displaySortedVotes() {
        System.out.println("Votes sorted by candidate name:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Display sorted results in descending order (reverse sorting)
    public void displaySortedVotesDescending() {
        System.out.println("Votes sorted by candidate name in descending order:");
        TreeMap<String, Integer> reverseSortedVotes = new TreeMap<>(Collections.reverseOrder());
        reverseSortedVotes.putAll(sortedVotes);

        for (Map.Entry<String, Integer> entry : reverseSortedVotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Display the winner (candidate with most votes)
    public String getWinner() {
        return Collections.max(votes.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

public class VotingSystemDemo {

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Simulating votes
        votingSystem.vote("Alice");
        votingSystem.vote("Bob");
        votingSystem.vote("Alice");
        votingSystem.vote("Charlie");
        votingSystem.vote("Bob");
        votingSystem.vote("Alice");

        // Displaying results
        votingSystem.displayVotesInOrder();
        votingSystem.displaySortedVotes();
        votingSystem.displaySortedVotesDescending();

        // Displaying the winner
        System.out.println("\nThe winner is: " + votingSystem.getWinner());
    }
}
