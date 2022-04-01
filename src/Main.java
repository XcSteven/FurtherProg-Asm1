import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Main implements StudentEnrollmentManager {
    static ArrayList<Student> student_list = new ArrayList<>();
    static ArrayList<Course> course_list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String choice = "";

    public static Student studentFind(String id) {
        for (int i = 0; i < student_list.size(); i++) {
            if (Objects.equals(student_list.get(i).getStudentID(), id)) {
                System.out.println(student_list.get(i));
                return student_list.get(i);
            }
        }
        return null;
    }

    public static Course courseFind(String id) {
        for (int i = 0; i < course_list.size(); i++) {
            if (Objects.equals(course_list.get(i).getCourseID(), id)) {
                return course_list.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Student s1 = new Student("s1234567", "Bruh", "1/1/2002");
        student_list.add(s1);
        Student s2 = new Student("s7654321", "Lmao", "12/31/2002");
        student_list.add(s2);

        Course c1 = new Course("C111", "Intro to Programming",12);
        course_list.add(c1);
        Course c2 = new Course("C222", "Intro to Management",12);
        course_list.add(c2);
        Course c3 = new Course("C333", "Intro to Design",12);
        course_list.add(c3);
        System.out.println("""
                Welcome to RMIT Student Enrolment Managing System
                1. Add an enrolment
                2. Update an enrolment
                3. Delete an enrolment
                *********************************************
                4. Get all students
                5. Get all courses
                6. Get all enrolments
                *********************************************
                7. Get all courses of a student in a semester
                8. Get all students of a course in a semester
                9. Get all courses offered in a semester
                0. Quit""");
        System.out.print("Choose an option: ");
        choice = sc.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Enter the student ID: ");
                String sID = sc.nextLine();
                Student student = studentFind(sID);

                System.out.print("Enter the course ID: ");
                String cID = sc.nextLine();
                Course course = courseFind(cID);

                System.out.print("Enter the semester to be enrolled in: ");
                String semester = sc.nextLine();

                StudentEnrollmentManager.add(student, course, semester);
                System.out.println(StudentEnrollmentManager.enrolment_list);
                break;

            case "2":
                System.out.println("2");
                break;

            case "3":
                System.out.println("3");
                break;
            case "4":
                System.out.println("4");
                break;

            case "5":
                System.out.println("5");
                break;

            case "6":
                break;

            case "7":
                System.out.println("7");
                break;

            case "8":
                System.out.println("8");
                break;

            case "9":
                System.out.println("9");
                break;

            case "0":
                System.out.println("Thank you for using our system!");
                System.exit(0);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void getOne() {

    }

    @Override
    public void getAll() {

    }
}
