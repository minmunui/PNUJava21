import java.util.Arrays;

public class PrimeNumberMain {
    public static void main ( String[] args ) {
        System.out.println("Enter a number:");
        for ( int i = 2 ; i <= 10 ; i ++ ) {
            System.out.println("Prime Numbers less than or equal to " + i + " = " + Arrays.toString(getPrimeNumber(i)));
        }
    }

    private static Integer[] getPrimeNumber (final int n) {
        Integer primeNumbers[] = new Integer[n];
        Arrays.fill(primeNumbers, 0);
        int cursor = 2;
        int index = 0;
        while(cursor <= n){
            if ( isPrime(cursor) ) {
                primeNumbers[index] = Integer.valueOf(cursor);
                index++;
            }
            cursor ++;
        }
        return Arrays.copyOf(primeNumbers, index);
    }
    private static boolean isPrime( int input ) {
        for ( int i = 2 ; i < input ; i ++ ) {
            if ( input%i == 0 ) {
                return false;
            }
        }
        return true;
    }
}
