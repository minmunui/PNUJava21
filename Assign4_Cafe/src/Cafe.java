import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Cafe{
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
        StringBuilder msg = new StringBuilder("Cafe Name: " + name + " Beverage Count: " + menus.size() + "\n");
        for (Beverage beverage : menus.values()) {
            msg.append("\t").append(beverage).append("\n");
        }
        return msg.toString();
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


