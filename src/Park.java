public class Park {
        class Attraction {
            String name;
            String time;
            double cost;
            Attraction (String name, String time, double cost) {
                this.name = name;
                this.time = time;
                this.cost = cost;
            }
            void printInfo() {
                System.out.println("Аттракцион: " + name + " "
                        + "Время работы: " + time + " "
                        + "Стоимость: " + cost);
            }
        }
    }
