package gof.java.designpatterns.factorymethod.java;


import gof.java.designpatterns.abstract_factory.after.after.BlackShip;
import gof.java.designpatterns.abstract_factory.after.after.WhiteShip;

public class SimpleFactory {

    public Object createProduct(String name) {
        if (name.equals("whiteship")) {
            return new WhiteShip();
        } else if (name.equals("blackship")) {
            return new BlackShip();
        }

        throw new IllegalArgumentException();
    }
}
