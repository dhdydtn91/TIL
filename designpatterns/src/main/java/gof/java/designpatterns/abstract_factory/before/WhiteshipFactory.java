package gof.java.designpatterns.abstract_factory.before;


import gof.java.designpatterns.abstract_factory.after.after.Ship;
import gof.java.designpatterns.abstract_factory.after.after.ShipFactory;
import gof.java.designpatterns.abstract_factory.after.after.WhiteShip;

public class WhiteshipFactory implements ShipFactory {

    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(new WhiteAnchor());
        ship.setWheel(new WhiteWheel());
        return ship;
    }
}
