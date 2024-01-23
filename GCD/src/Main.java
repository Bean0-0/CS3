import java.util.*;
public class Main {
    public static int gcd(int x, int y) {
        System.out.println("Calling gcd(" + x + ", " + y + ")");
        if (y == 0) {
            System.out.println("Returning " + x);
            return x;
        } else {
            int result = gcd(y, x % y);
            System.out.println("Returning " + result + " from gcd(" + x + ", " + y + ")");
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int x = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int y = scanner.nextInt();

        int gcd = gcd(x, y);
        System.out.println("GCD: " + gcd);
    }
}
