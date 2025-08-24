public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Zosya");
        Dog dog1 = new Dog("Rich");
        cat1.run(150);
        cat1.run(201);
        cat1.swim(10);
        dog1.run(500);
        dog1.run(501);
        dog1.swim(5);
        dog1.swim(15);
        System.out.println("Total animals: " + Animal.getCountAnimal());
        System.out.println("Total cats: " + Cat.getCountCat());
        System.out.println("Total dogs: " + Dog.getCountDog());
        System.out.println("Feeding cats:");
        Cat[] cats = {new Cat("Gabi"), new Cat("Barsik"), new Cat("Garfild")};
        Bowl bowl = new Bowl(25);
        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }
        System.out.println("Cats satiety:");
        for (Cat cat : cats) {
            if (cat.isSatiety()){
                System.out.println(cat.name + " is full");
            } else {
                System.out.println(cat.name + " is hungry");
            }
        }
        System.out.println("Add food and feed again:");
        bowl.addFood(20);
        cats[2].eat(bowl, 10);
        System.out.println(cats[2].name + " is " + (cats[2].isSatiety() ? "full" : "hungry"));
        System.out.println();

        Shape circle = new Circle(5, "Red", "White");
        Shape rectangle = new Rectangle(4, 7, "Black", "Yellow");
        Shape triangle = new Triangle(3, 4, 5, "Pink", "Blue");
        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}
class Animal {
    static int countAnimal = 0;
    Animal() {
        countAnimal ++;
    }
    void run(int distance) {
        System.out.println("Animal run " + distance + " m");
    }
    void swim (int distance) {
        System.out.println("Animal swim " + distance + " m");
    }
    static int getCountAnimal() {
        return countAnimal;
    }
}

class Dog extends Animal {
    String name;
    static int countDog = 0;
    Dog (String name) {
        super();
        countDog++;
        this.name = name;
    }

    @Override
    void run(int distance) {
        if (distance > 500) {
            System.out.println(name + " can't run more than 500m");
        } else {
            System.out.println(name + " run " + distance + " m");
        }
    }

 @Override
void swim (int distance) {
    if (distance > 10) {
        System.out.println(name + " can't swim more than 10m");
    } else {
        System.out.println(name + " swim " + distance + " m");
    }
 }

 static int getCountDog(){
    return countDog;
    }
}

class Cat extends Animal {
    String name;
    static int countCat = 0;
    boolean satiety = false;

    Cat(String name) {
        super();
        countCat++;
        this.name = name;
    }

    @Override
    void run(int distance) {
        if (distance > 200) {
            System.out.println(name + " can't run more than 200m");
        } else {
            System.out.println(name + " run " + distance + " m");
        }
    }

    @Override
    void swim(int distance) {
        System.out.println("Cat can't swim");
    }

    void eat(Bowl bowl, int foodAmount) {
        if (bowl.food >= foodAmount) {
            bowl.food = bowl.food - foodAmount;
            satiety = true;
            System.out.println(name + " ate " + foodAmount + " food and is full");
        } else {
            System.out.println(name + " didn't eat (not enough food)");
        }
    }

    boolean isSatiety() {
        return satiety;
    }

    static int getCountCat() {
        return countCat;
    }
}
class Bowl {
    int food;

    Bowl(int food) {
        this.food = food;
    }
    void addFood(int amount) {
        food = food + amount;
        System.out.println("Added " + amount + "food. Now bowl has" + food);
    }
}

interface Shape {
    double getArea();
    double getPerimeter();
    String getFillColor();
    String getBorderColor();
default void printInfo() {
    System.out.println("Area: " + getArea());
    System.out.println("Perimeter: " + getPerimeter());
    System.out.println("Fill color: " + getFillColor());
    System.out.println("Border color: " + getBorderColor());
}
}
class Circle implements Shape{
    private double radius;
    private String fillColor;
    private String borderColor;
    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }
    @Override
    public String getFillColor(){
        return fillColor;
    }
    @Override
    public String getBorderColor(){
        return borderColor;
    }
}
class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;
    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
@Override
    public double getArea(){
        return width * height;
}
@Override
    public double getPerimeter() {
        return 2 * (width + height);
}
@Override
    public String getFillColor() {
        return fillColor;
}
@Override
    public String getBorderColor() {
        return borderColor;
}
}
class Triangle implements Shape {
    private double a, b, c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double getArea(){
        double p = getPerimeter() / 2;
        return  Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    @Override
    public double getPerimeter() {
        return a + b + c;
    }
    @Override
    public String getFillColor() {
        return fillColor;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}


