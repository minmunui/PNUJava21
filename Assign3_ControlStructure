import java.util.Scanner;
import java.util.Arrays;

enum Command { ADD, LIST, SRTA, SRTD, SUM, QUIT, INVALID}
enum Order { ASC, DSC, INVALID }

public class ArrayEnum {
    public static void main ( String args[] ) {
        final Scanner scanner = new Scanner(System.in);
        final int values[] = new int[100];

        int index = 0;
        while ( true ) {
            final Command command = getCommand(scanner);
            if ( command == Command.QUIT ) {
                System.out.println("Bye!");
                break;
            }
            switch ( command ) {
                case ADD:
                    final int newValue = getValue(scanner);
                    values[index] = newValue;
                    index++;
                    break;
                case LIST:
                    printList(values, index);
                    break;
                case SRTA:
                    printList(sort(values, index, Order.ASC), index);
                    break;
                case SRTD:
                    printList(sort(values, index, Order.DSC), index);
                    break;
                case SUM:
                    System.out.println(sumOfValues(values, index));
                    break;
                case INVALID:
                    System.out.println("Invalid Command");
                    break;
            }
        }
        scanner.close();
    }

    public static int getValue(Scanner inputScanner) {
        return inputScanner.nextInt();
    }

    public static Command getCommand(Scanner inputScanner) {
        switch (inputScanner.next().toUpperCase()) {
            case "ADD" : return Command.ADD;
            case "LIST": return Command.LIST;
            case "SRTA": return Command.SRTA;
            case "SRTD": return Command.SRTD;
            case "SUM" : return Command.SUM;
            case "QUIT": return Command.QUIT;
            default: return Command.INVALID;
        }
    }
    public static int printList( int[] inputArray, int index ) {
        for ( int i = 0 ; i < index ; i ++ ) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
        return 0;
    }
    public static int[] sort ( int[] inputArray, int index, Order inputOrder) {
        int[] resultArray = Arrays.copyOf(inputArray, index);
        for ( int i = 0 ; i < index ; i ++ ) {
            int minOrMax = resultArray[i];
            for ( int j = i ; j < index ; j ++ ) {
                if ( (minOrMax > resultArray[j]) && (inputOrder == Order.ASC) ) {
                    int temp = resultArray[j];
                    resultArray[j] = minOrMax;
                    minOrMax = temp;
                }
                if ( ( minOrMax < resultArray[j]) && (inputOrder == Order.DSC) ) {
                    int temp = resultArray[j];
                    resultArray[j] = minOrMax;
                    minOrMax = temp;
                }
            }
            resultArray[i] = minOrMax;
        }
        return resultArray;
    }
    public static int sumOfValues( int[] inputArray, int index) {
        int sum = 0 ;
        for ( int i = 0 ; i < index ; i ++ ) {
            sum += inputArray[i];
        }
        return sum;
    }
}
