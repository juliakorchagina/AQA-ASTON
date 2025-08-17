public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro ", "09.09.2024", "Apple Inc", "USA", 4999, true);
        productsArray[2] = new Product("iPhone 14 Pro", "07.09.2022", "Apple Inc", "USA", 3999, false);
        productsArray[3] = new Product("iPad 4", "23.10.2012", "Apple Inc", "USA", 999, false);
        productsArray[4] = new Product("iPod Shuffle", "11.01.2005", "Apple Inc", "USA", 19, false);
        for (int i = 0; i < 5; i++) {
            System.out.println("Товар " + (i + 1) + ":");
            System.out.println("Название: " + productsArray[i].name);
            System.out.println("Дата выпуска: " + productsArray[i].date);
            System.out.println("Производитель: " + productsArray[i].manufacturer);
            System.out.println("Страна: " + productsArray[i].country);
            System.out.println("Цена: " + productsArray[i].cost);
            System.out.println("В наличии: " + productsArray[i].availability);
            System.out.println();
        }
    }
}
class Product {
    String name;
    String date;
    String manufacturer;
    String country;
    double cost;
    boolean availability;
    public Product (String name, String date, String manufacturer, String country, int cost, boolean availability) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.cost = cost;
        this.availability = availability;
    }
}
