package gof.java.designpatterns.abstract_factory.after;

import gof.java.designpatterns.factorymethod.after.Ship;
import gof.java.designpatterns.factorymethod.after.ShipFactory;
import gof.java.designpatterns.factorymethod.after.WhiteShip;

public class WhiteshipFactory implements ShipFactory {

    private ShipPartsFactory shipPartsFactory;

    public WhiteshipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
