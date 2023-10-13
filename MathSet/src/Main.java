public class Main {
    public static void main(String[] args) {

        MathSet mathSet = new MathSet("1 2 3 4 5", "4 5 6 7 8");

        // Display the results of the set operations
        System.out.println("Union:");
        System.out.println(mathSet.union());

        System.out.println("Intersection:");
        System.out.println(mathSet.intersection());

        System.out.println("Difference A-B:");
        System.out.println(mathSet.differenceAMinusB());

        System.out.println("Difference B-A:");
        System.out.println(mathSet.differenceBMinusA());

        System.out.println("Symmetric difference:");
        System.out.println(mathSet.symmetricDifference());
    }
}