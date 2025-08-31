import java.util.List;

class Student {
    String name;
    String group;
    int course;
    List<Integer> grades;

    Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    double getAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}
