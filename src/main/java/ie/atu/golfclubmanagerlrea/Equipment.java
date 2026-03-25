package ie.atu.golfclubmanagerlrea;


public class Equipment {
    String name;
    String category;
    double price;
    boolean available;

    public Equipment(String name, String category, double price, boolean available) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
    }
}
