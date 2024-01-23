import java.util.Scanner;

public class loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int x = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int y = scanner.nextInt();

        System.out.println("Progression of values:");

        while (y != 0) {
            System.out.println("X = " + x + ", Y = " + y);
            int temp = y;
            y = x % y;
            x = temp;
        }

        System.out.println("GCD: " + x);
    }
}
