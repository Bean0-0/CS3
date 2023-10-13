import java.util.*;

public class Main {

    public static void main(String[] args) {

        Sorts sorts = new Sorts();

        int[] array1 = new int[1000];
        //best
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i;
        }

        int[] array2 = new int[1000];
        //worst
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array2.length - i - 1;
        }

        int[] array3 = new int[1000];
        //random
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (int) Math.random();
        }



        // Calculate the average time for each case
        long bestCaseAvgTime = sortArray(sorts, array1);;
        long worstCaseAvgTime = sortArray(sorts, array2);;
        long randomCaseAvgTime = sortArray(sorts, array3);;

        // Determine the best fitting Big O notation
        String bestCaseBigO = determineBigONotation(bestCaseAvgTime);
        String worstCaseBigO = determineBigONotation(worstCaseAvgTime);
        String randomCaseBigO = determineBigONotation(randomCaseAvgTime);

        // Print the results
        printResults(bestCaseAvgTime, worstCaseAvgTime, randomCaseAvgTime, bestCaseBigO, worstCaseBigO, randomCaseBigO);
    }

    //bubbleSort
    private static long sortArray(Sorts sorts, int[] array) {
        long startTime = System.nanoTime();
        sorts.bubbleSort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }


    private static String determineBigONotation(long avgTime) {
        if (avgTime <= 1) {
            return "O(1)";
        } else if (avgTime <= 10 * Math.log(avgTime)) {
            return "O(log n)";
        } else if (avgTime <= 10 * avgTime * avgTime) {
            return "O(n^2)";
        } else {
            return "O(n^3)";
        }
    }

    private static void printResults(long bestCaseAvgTime, long worstCaseAvgTime, long randomCaseAvgTime, String bestCaseBigO, String worstCaseBigO, String randomCaseBigO) {
        System.out.println("Best case average time: " + bestCaseAvgTime + " ns");
        System.out.println("Best case Big O notation: " + bestCaseBigO);
        System.out.println("Worst case average time: " + worstCaseAvgTime + " ns");
        System.out.println("Worst case Big O notation: " + worstCaseBigO);
        System.out.println("Random case average time: " + randomCaseAvgTime + " ns");
        System.out.println("Random case Big O notation: " + randomCaseBigO);
    }
}