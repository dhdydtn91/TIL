package gof.java.designpatterns.factorymethod.after;

import gof.java.designpatterns.factorymethod.after.Ship;

public class WhiteShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
