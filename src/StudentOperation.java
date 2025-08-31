import java.util.HashSet;
import java.util.Set;

class StudentOperation {
    static void removeLowGrades(Set<Student> students) {
        Set<Student> toRemove = new HashSet<>();
        for (Student s : students) {
            if (s.getAverage() < 3) {
                toRemove.add(s);
            }
        }
        students.removeAll(toRemove);
    }

    static void promoteStudents(Set<Student> students) {
        for (Student s : students) {
            if (s.getAverage() >= 3) {
                s.course++;
            }
        }
    }
    static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты курса " + course + ":");
        for (Student s : students) {
            if (s.course == course) {
                System.out.println(s.name);
            }
        }
    }
}
