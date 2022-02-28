package gof.java.designpatterns.abstract_factory.after.after;

public class BlackShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
