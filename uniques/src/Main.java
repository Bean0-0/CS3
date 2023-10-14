public class Main {
    public static void main(String[] args) {
        UniquesDupes test = new UniquesDupes();
        System.out.println(test.getDupes("one two three one two three six seven one two"));
        System.out.println(test.getUniques("one two three one two three six seven one two"));
    }
}