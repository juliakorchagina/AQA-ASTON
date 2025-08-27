public class Product {
    String name;
    String date;
    String manufacturer;
    String country;
    double cost;
    boolean availability;

    public Product(String name, String date, String manufacturer, String country, int cost, boolean availability) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.cost = cost;
        this.availability = availability;
    }
}
