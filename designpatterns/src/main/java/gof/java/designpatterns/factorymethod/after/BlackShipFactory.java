package gof.java.designpatterns.factorymethod.after;

public class BlackShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new Blackship();
    }
}
