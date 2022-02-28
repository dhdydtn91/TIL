package gof.java.designpatterns.abstract_factory.after.after;


public class WhiteShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
