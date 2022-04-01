import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Main implements StudentEnrolmentManager {
    static ArrayList<Student> student_list = new ArrayList<>();
    static ArrayList<Course> course_list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String choice = "";

    public static Student studentFind(String id) {
        for (int i = 0; i < student_list.size(); i++) {
            if (Objects.equals(student_list.get(i).getStudentID(), id)) {
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
        Student stu1 = new Student("s1234567", "Bruh", "1/1/2002");
        student_list.add(stu1);
        Student stu2 = new Student("s7654321", "Lmao", "12/31/2002");
        student_list.add(stu2);

        Course cou1 = new Course("C111", "Intro to Programming",12);
        course_list.add(cou1);
        Course cou2 = new Course("C222", "Intro to Management",12);
        course_list.add(cou2);
        Course cou3 = new Course("C333", "Intro to Design",12);
        course_list.add(cou3);

        while (true) {
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
                String s1 = sc.nextLine();
                Student student = studentFind(s1);
                if (student != null) {
                    System.out.print("Enter the course ID: ");
                    String c1 = sc.nextLine();
                    Course course = courseFind(c1);
                    if (course != null) {
                        System.out.print("Enter the semester to be enrolled in: ");
                        String sem1 = sc.nextLine();
                        StudentEnrolmentManager.add(student, course, sem1);
                    }
                } else {
                    System.out.println();
                }
                break;

            case "2":
                System.out.println("2");
                break:

            case "3":
                System.out.print("Enter the student ID: ");
                String s3 = sc.nextLine();
                System.out.print("Enter the course ID: ");
                String c3 = sc.nextLine();
                System.out.print("Enter the semester of the enrolment: ");
                String sem3 = sc.nextLine();
                StudentEnrolmentManager.delete(s3, c3, sem3);
                break;

            case "4":
                System.out.println("4");
                break;

            case "5":
                System.out.println("5");
                break;

            case "6":
                StudentEnrolmentManager.getAll();
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
                
            default:
                System.out.println("That is not a valid option, please try again.");
            }
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void getOne() {

    }
}
