import java.util.Scanner;

enum StringCommand { ADD, SORT, REMOVE, CLEAN, QUIT, INVALID};

public class StringSetManager {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] stringSet = new String[100];
        while ( true ) {
            final StringCommand command = getCommand(scanner);
            if ( command == StringCommand.QUIT) {
                System.out.println("BYE"); break;
            }
            switch (command) {
                case ADD :
                    final String stringToAdd = getString(scanner);
                    add(stringSet, stringToAdd);
                    break;
                case SORT:
                    final String order = getString(scanner);
                    sort(stringSet, order);
                    break;
                case REMOVE:
                    final String stringToRemove = getString(scanner);
                    remove(stringSet, stringToRemove);
                    break;
                case CLEAN:
                    clean(stringSet);
                    break;
                default:
                    System.out.println("Invalid Command");
            }
            print(stringSet);
        }
    }

    static StringCommand getCommand(Scanner scanner) {
        String input = scanner.next();
        switch ( input.toUpperCase() ) {
            case "ADD" : return StringCommand.ADD;
            case "SORT": return StringCommand.SORT;
            case "REMOVE" : return StringCommand.REMOVE;
            case "CLEAN" : return StringCommand.CLEAN;
            case "QUIT" : return StringCommand.QUIT;
            default: return StringCommand.INVALID;
        }
    }
    static String getString(Scanner scanner) {
        return scanner.next();
    }
    static void print(String[] stringSet) {
        System.out.printf("Element Size: %d, Values = ", getEnd(stringSet));
        System.out.print("[");
        for ( int i = 0 ; i < getEnd(stringSet) ; i ++ ) {
            System.out.print(stringSet[i]);
            if ( i + 1 != getEnd(stringSet)) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    static void add( String[] stringSet, String stringToAdd ) {
        if ( searchInArray(stringSet, stringToAdd) == -1) {
            stringSet[getEnd(stringSet)] = stringToAdd;
        }
    }
    static void remove( String[] stringSet, String stringToRemove) {
        if ( searchInArray(stringSet, stringToRemove) != -1) {
            removeFromIndex(stringSet, searchInArray(stringSet, stringToRemove));
        }
    }
    static void removeFromIndex( Object[] objectSet, int index ) {
        for ( ; objectSet[index+1] != null ; index ++ ) {
            objectSet[index] = objectSet[index+1];
        }
        objectSet[index] = null;
    }
    static void clean( String[] stringSet) {
        for ( int i = getEnd(stringSet) ; i!=-1 ; i -- ) {
            stringSet[i] = null;
        }
    }
    static void sort(String[] stringSet, String sortingWay) {
        if ( sortingWay.toUpperCase().equals("ASC")) {
            for ( int i = 0 ; i < getEnd(stringSet) ; i ++ ) {
                swapInArray(stringSet, i, getPriorityIndex(stringSet, i, getEnd(stringSet)));
            }
        }
        else if ( sortingWay.toUpperCase().equals("DESC")) {
            for ( int i = 0 ; i < getEnd(stringSet) ; i++ ){
                swapInArray(stringSet, i, getPosteriorIndex(stringSet, i, getEnd(stringSet)));
            }
        }
    }
    static int getPriorityIndex(String[] stringSet, int firstIndex, int lastIndex ) {
        int priority = firstIndex;
        for ( int i = firstIndex ; i < lastIndex ; i ++ ) {
            if ( stringSet[i].compareTo(stringSet[priority]) < 0 ) {
                priority = i;
            }
        }
        return priority;
    }
    static int getPosteriorIndex( String[] stringSet, int firstIndex, int lastIndex ) {
        int posterior = firstIndex;
        for ( int i = firstIndex ; i < lastIndex ; i++ ) {
            if ( stringSet[i].compareTo(stringSet[posterior]) > 0) {
                posterior = i;
            }
        }
        return posterior;
    }
    static void swapInArray( String[] stringSet, int i1, int i2) {
        String temp = stringSet[i1];
        stringSet[i1] = stringSet[i2];
        stringSet[i2] = temp;
    }
    static int getEnd( String[] stringSet ) {
        for ( int i = 0 ; i < 100 ; i ++ ){
            if ( stringSet[i] == null ) {
                return i;
            }
        }
        System.out.println("There are no end of stringSet");
        return -1;
    }
    static int searchInArray ( String[] stringSet, String stringToSearch ) {
        for ( int i = 0 ; i <= getEnd(stringSet) ; i++ ) {
            if ( stringToSearch.equals(stringSet[i])) {
                return i;
            }
        }
        return -1;
    }
}
