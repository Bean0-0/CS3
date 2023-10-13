import java.util.*;
import java.io.*; 

public class MatrixSearchRunner
{
    public static void main(String[] args) throws Exception
    {
    	  MatrixSearch ms = new MatrixSearch(14, 14, 25);
        System.out.println( "Odd count = " + ms.countOdds() );
        System.out.println(ms.countEvens());
        System.out.println(ms.countPrimes());
        System.out.println(ms.toString());
    }
}
