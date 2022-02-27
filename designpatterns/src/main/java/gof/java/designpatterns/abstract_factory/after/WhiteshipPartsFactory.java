package gof.java.designpatterns.abstract_factory.after;

import gof.java.designpatterns.abstract_factory.before.WhiteAnchor;
import gof.java.designpatterns.abstract_factory.before.WhiteWheel;


public class WhiteshipPartsFactory implements ShipPartsFactory {

    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
