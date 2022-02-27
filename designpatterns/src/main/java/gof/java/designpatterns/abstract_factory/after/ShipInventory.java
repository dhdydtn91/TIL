package gof.java.designpatterns.abstract_factory.after;


import gof.java.designpatterns.factorymethod.after.Ship;
import gof.java.designpatterns.factorymethod.after.ShipFactory;

public class ShipInventory {

    public static void main(String[] args) {
        ShipFactory shipFactory = new WhiteshipFactory(new WhiteshipPartsFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
