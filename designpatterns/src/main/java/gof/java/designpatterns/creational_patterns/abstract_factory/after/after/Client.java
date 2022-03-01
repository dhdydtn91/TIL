package gof.java.designpatterns.creational_patterns.abstract_factory.after.after;

public class Client {

    private void print (ShipFactory shipFactory, String name, String email){
        System.out.println(shipFactory.orderShip(name,email));
    }
    public static void main(String[] args) {
        Client client = new Client();

        client.print(new WhiteShipFactory() , "whiteship", "dhdydtn1993@gmail.comn");
        client.print(new BlackShipFactory() , "blackship", "dhdydtn1993@gmail.comn");
    }

}
