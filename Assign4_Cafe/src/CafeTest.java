import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.Iterator;

enum Command{ADD, FIND, CLEAR, LIST, QUIT, INVALID}
public class CafeTest {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Cafe starbucks = new Cafe("Starbucks");
        while ( true ) {
            final Command cmd = getCommand(scanner);
            if ( cmd == Command.QUIT ) {
                System.out.println("Bye");
                break;
            }
            if ( cmd == Command.INVALID ) {
                System.out.println("Invalid Operation!");
                continue;
            }
            switch (cmd) {
                case ADD : {
                    Beverage newBeverage = createBeverage();
                    starbucks.addBeverage(newBeverage);
                    break;
                }
                case FIND : {
                    findBeverage(starbucks);
                    break;
                }
                case CLEAR :
                    starbucks.removeAllBeverage();
                    break;
                case LIST :
                    System.out.println(starbucks);
                    break;
                default:
            }
        }
    }
    static Command getCommand(Scanner scanner) {
        String input = scanner.next();
        switch ( input.toUpperCase() ) {
            case "ADD" : return Command.ADD;
            case "FIND": return Command.FIND;
            case "CLEAR" : return Command.CLEAR;
            case "LIST" : return Command.LIST;
            case "QUIT" : return Command.QUIT;
            default: return Command.INVALID;
        }
    }
    private static void findBeverage(final Cafe cs) {
        final String name = scanner.next();
        final String type = scanner.next().toUpperCase();
        final Beverage foundBeverage = cs.findBeverage(name, type);
        if ( foundBeverage != null ) {
            System.out.println(foundBeverage);
        }
        else {
            System.out.println("Beverage Not Found with name " + name + " and type " + type);
        }
    }
    private static Beverage createBeverage() {
        final String name = scanner.next();
        final String type = scanner.next().toUpperCase();
        return new Beverage(name, type);
    }
}

class Cafe{
    private String name;
    private HashMap<String, Beverage> menus = new HashMap<>();

    public Beverage findBeverage(String name, String type) {
        Iterator<Beverage> values = menus.values().iterator();
        Beverage beverageToFind = new Beverage(name, type);
        while (values.hasNext()) {
            if ( beverageToFind.equals(values.next())) {
                return beverageToFind;
            }
        }
        return null;
    }

    public void addBeverage(Beverage beverage) {
        menus.putIfAbsent(beverage.toString(), beverage);
        System.out.println();
    }

    public void removeAllBeverage() {
        menus.clear();
    }

    public String toString() {
        String msg = "Cafe Name: " + name + " Beverage Count: " + menus.size() + "\n";
        Iterator<Beverage> values = menus.values().iterator();
        while (values.hasNext()) {
            msg += "\t" + values.next() + "\n";
        }
        return msg;
    }

    public Cafe(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return Objects.equals(name, cafe.name) && Objects.equals(menus, cafe.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, menus);
    }
}

class Beverage {
    private String type;
    private String name;

    public String getBeverageName() {
        return name;
    }

    public Beverage(String name, String type) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "["+this.name+", "+this.type+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beverage beverage = (Beverage) o;
        return Objects.equals(type, beverage.type) && Objects.equals(name, beverage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}