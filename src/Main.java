import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        System.out.println("""
                Welcome to RMIT Student Enrolment Managing System
                1. Add an enrolment
                2. Update an enrolment
                3. Delete an enrolment
                #############################################
                4. Get all students
                5. Get all courses
                6. Get all enrolments
                #############################################
                7. Get all courses of a student in a semester
                8. Get all students of a course in a semester
                9. Get all courses offered in a semester
                0. Quit""");
        System.out.print("Choose an option: ");
        if (sc.hasNext()) {
            choice = sc.next();
        }

        switch (choice) {
            case "1":
                System.out.println("1");
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
                StudentEnrolment enroll = new StudentEnrolment();
                enroll.getAllEnrolment();
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
}
