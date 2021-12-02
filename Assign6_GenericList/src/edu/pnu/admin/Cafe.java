package edu.pnu.admin;

import edu.pnu.collection.*;
public class Cafe {
    private String name;
    private GenericList<Beverage> menus = new GenericList<Beverage>();
    public Cafe(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder msg = new StringBuilder("Cafe Name: " + name + " Beverage Count: " + menus.size() + "\n");
        msg.append(menus.toString());
        return msg.toString();
    }

    public void addBeverage(Beverage beverageToAdd) {
        menus.addObject(beverageToAdd);
    }

    public void removeAllBeverage() {
        menus.clear();
    }
    public Beverage findBeverage(Beverage objectToFind) {
        return menus.findObject(objectToFind);
    }
    public Beverage findBeverage(String name, String type) {
        return menus.findObject(new Beverage(name, type));
    }
}
