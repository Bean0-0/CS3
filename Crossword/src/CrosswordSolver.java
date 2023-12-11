import java.io.*;
import java.util.*;

public class CrosswordSolver {

    private static final int MAX_WORD_LENGTH = 7;

    public static void main(String[] args) throws IOException {
        // Read the word bank into a set
        Set<String> wordBank = new HashSet<>();
        Scanner scanner = new Scanner(new File("//Users//ben//IdeaProjects//CS3//Crossword//src//crosswordclues.dat"));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                wordBank.add(scanner.next());
            }
        }

        // Read the partial words and find matches
        while (scanner.hasNextLine()) {
            String partialWord = scanner.nextLine();
            List<String> matches = findMatches(partialWord, wordBank);

            if (matches.isEmpty()) {
                System.out.println("NO MATCH");
            } else {
                for (String match : matches) {
                    System.out.print(match + " ");
                }
                System.out.println();
            }
        }
    }

    private static List<String> findMatches(String partialWord, Set<String> wordBank) {
        List<String> matches = new ArrayList<>();
        for (String word : wordBank) {
            if (isMatch(partialWord, word)) {
                matches.add(word);
            }
        }
        return matches;
    }

    private static boolean isMatch(String partialWord, String word) {
        if (word.length() != partialWord.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (partialWord.charAt(i) == '*' || partialWord.charAt(i) == word.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
