import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Кирилл", "КР31", 2, Arrays.asList(3, 3, 4)));
        students.add(new Student("Юля", "ИВТз202", 1, Arrays.asList(4, 5, 5)));
        students.add(new Student("Оля", "ММЗ217", 1, Arrays.asList(2, 2, 4)));
        System.out.println("Список студентов ДО отчисления и перевода на следующий курс:");
        StudentOperation.printStudents(students, 1);
        StudentOperation.printStudents(students, 2);
        StudentOperation.removeLowGrades(students);
        StudentOperation.promoteStudents(students);
        System.out.println("Список студентов ПОСЛЕ отчисления и перевода на следующий курс:");
        StudentOperation.printStudents(students, 1);
        StudentOperation.printStudents(students, 2);
        StudentOperation.printStudents(students, 3);

        System.out.println("Телефонный справочник: ");
        PhoneBook book = new PhoneBook();
        book.add("Субочева", "313758");
        book.add("Гридяева", "700960");
        book.add("Субочева", "794481");
        book.get("Субочева");
        book.get("Гридяева");
        book.get("Корчагин");
    }
}
