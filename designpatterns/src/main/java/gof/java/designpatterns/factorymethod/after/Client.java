package gof.java.designpatterns.factorymethod.after;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteShip = new WhiteShipFactory().orderShip("Whiteship", "dhdydtn1993@gmail.comn");
        System.out.println(whiteShip);

        Ship blackShip = new WhiteShipFactory().orderShip("Blackship", "dhdydtn1993@gmail.comn");
        System.out.println(blackShip);
    }

}
