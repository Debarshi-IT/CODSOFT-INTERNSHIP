import java.util.*;

class Course {
    String code, title, description, schedule;
    int capacity;
    int enrolled;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
        this.schedule = schedule;
    }

    public boolean isAvailable() {
        return enrolled < capacity;
    }

    public void enrollStudent() {
        if (isAvailable()) enrolled++;
    }

    public void dropStudent() {
        if (enrolled > 0) enrolled--;
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.isAvailable()) {
            registeredCourses.add(course);
            course.enrollStudent();
            System.out.println("Successfully registered for " + course.title);
        } else {
            System.out.println("Course is full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.dropStudent();
            System.out.println("Successfully dropped " + course.title);
        } else {
            System.out.println("You are not registered in this course.");
        }
    }
}

public class CodSoft_Task5 {
    private static final List<Course> courses = new ArrayList<>();
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        showCourses();
        Student student = new Student("S101", "Alice");
        students.add(student);

        student.registerCourse(courses.get(0));
        student.registerCourse(courses.get(1));
        student.dropCourse(courses.get(0));
    }

    private static void initializeData() {
        courses.add(new Course("CS101", "Intro to Programming", "Basic programming concepts", 2, "MWF 10-11 AM"));
        courses.add(new Course("MTH101", "Calculus I", "Differentiation and Integration", 3, "TTh 2-3 PM"));
    }

    private static void showCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course.code + " - " + course.title + " (" + course.enrolled + "/" + course.capacity + ")");
        }
    }
}
