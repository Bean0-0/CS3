import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] tRay = new int[100];
        Random random = new Random();

        for (int i = 0; i < tRay.length; i++) {
            tRay[i] = random.nextInt(100);
        }

        int biggest = getBiggest(tRay);

        System.out.println("The biggest element in the array is: " + biggest);
    }
    public static int getBiggest(int[] tRay) {
        int big = Integer.MIN_VALUE;

        for( int item : tRay )
            if( tRay[item] > big )
                big = tRay[item];

        return big;
    }
}