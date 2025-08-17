public class MainClass {
    public static void main(String[] args) {
        Product product1 = new Product("Octavia", "01.01.2018", "VW AG", "Czech", 20000, true);
        product1.printInfo();
    }
}
class Product {
    private String name;
    private String date;
    private String manufacturer;
    private String country;
    private int cost;
    private boolean booking;
    public Product (String name, String date, String manufacturer, String country, int cost, boolean booking){
    this.name = name;
    this.date = date;
    this.manufacturer = manufacturer;
    this.country = country;
    this.cost = cost;
    this.booking = booking;
}
public void printInfo() {
    System.out.println(name);
    System.out.println(date);
    System.out.println(manufacturer);
    System.out.println(country);
    System.out.println(cost);
    System.out.println(booking);
}
}