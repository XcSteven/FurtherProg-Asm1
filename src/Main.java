import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Main implements StudentEnrolmentManager {
    static ArrayList<Student> student_list = new ArrayList<>();
    static ArrayList<Course> course_list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

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

    public static void allEnrolments() {
        for (int i = 0; i < StudentEnrolmentManager.getAll().size(); i++) {
            System.out.println(StudentEnrolmentManager.getAll().get(i));
        }
    }

    public static void main(String[] args) {
        Student stu1 = new Student("s1234567", "Bruh", "1/1/2002");
        student_list.add(stu1);
        Student stu2 = new Student("s7654321", "Lmao", "12/31/2002");
        student_list.add(stu2);

        Course cou1 = new Course("C111", "Intro to Programming", 12);
        course_list.add(cou1);
        Course cou2 = new Course("C222", "Intro to Management", 12);
        course_list.add(cou2);
        Course cou3 = new Course("C333", "Intro to Design", 12);
        course_list.add(cou3);

        StudentEnrolmentManager.getAll().add(new StudentEnrolment(stu1, cou1, "2021A"));
        StudentEnrolmentManager.getAll().add(new StudentEnrolment(stu1, cou3, "2021A"));
        StudentEnrolmentManager.getAll().add(new StudentEnrolment(stu1, cou2, "2021B"));

        String main;
        do {
            System.out.println("""
                    **************************************************
                    Welcome to RMIT Student Enrolment Managing System!
                    **************************************************
                    1. Show all enrolments
                    2. Enrol a student
                    3. Update an enrolment
                    4. Print
                    0. Quit""");
            System.out.print("Choose an option: ");
            main = sc.nextLine();

            switch (main) {
                case "1" -> {
                    System.out.println("""
                            ************************
                            ALL ENROLMENTS AVAILABLE
                            ************************""");
                    allEnrolments();
                }
                case "2" -> {
                    System.out.print("Enter the student ID: ");
                    String s1 = sc.nextLine();
                    Student student1 = studentFind(s1);
                    if (student1 != null) {
                        System.out.print("Enter the course ID: ");
                        String c1 = sc.nextLine();
                        Course course1 = courseFind(c1);
                        if (course1 != null) {
                            System.out.print("Enter the semester to be enrolled in: ");
                            String sem1 = sc.nextLine();
                            StudentEnrolmentManager.add(student1, course1, sem1);
                        } else {
                            System.out.println("*** No courses found! ***");
                        }
                    } else {
                        System.out.println("*** No students found! ***");
                    }
                }
                case "3" -> {
                    String s2;
                    String sem2;
                    ArrayList<Integer> semester_pointer = new ArrayList<>();
                    System.out.print("Enter the student ID: ");
                    s2 = sc.nextLine();
                    ArrayList<Integer> student_pointer = new ArrayList<>();
                    for (int i = 0; i < StudentEnrolmentManager.getAll().size(); i++) {
                        if (Objects.equals(StudentEnrolmentManager.getAll().get(i).getStudentID(), s2)) {
                            student_pointer.add(i);
                        }
                    }
                    if (student_pointer.size() != 0) {
                        System.out.print("Enter the semester: ");
                        sem2 = sc.nextLine();
                        for (int i = 0; i < student_pointer.size(); i++) {
                            if (Objects.equals(StudentEnrolmentManager.getAll().get(student_pointer.get(i)).getSemester(), sem2)) {
                                semester_pointer.add(i);
                            }
                        }
                        if (semester_pointer.size() != 0) {
                            for (int i = 0; i < semester_pointer.size(); i++) {
                                System.out.println(StudentEnrolmentManager.getAll().get(semester_pointer.get(i)));
                            }
                        } else {
                            System.out.println("*** That student is not enrolled in semester " + sem2 + ". ***");
                            break;
                        }
                    } else {
                        System.out.println("*** That student does not exist. ***");
                        break;
                    }
                    String sub1;
                    System.out.println("""
                            *******************
                            UPDATE AN ENROLMENT
                            *******************
                            1. Add a course
                            2. Delete a course
                            0. Back""");
                    System.out.print("Choose an option: ");
                    sub1 = sc.nextLine();
                    switch (sub1) {
                        case "1" -> {
                            Student student2 = studentFind(s2);
                            if (student2 != null) {
                                System.out.print("Enter the course ID: ");
                                String c2 = sc.nextLine();
                                Course course2 = courseFind(c2);
                                if (course2 != null) {
                                    StudentEnrolmentManager.add(student2, course2, sem2);
                                } else {
                                    System.out.println("*** No courses found! ***");
                                }
                            }
                        }
                        case "2" -> {
                            Student student3 = studentFind(s2);
                            if (student3 != null) {
                                System.out.print("Enter the course ID: ");
                                String c3 = sc.nextLine();
                                Course course3 = courseFind(c3);
                                if (course3 != null) {
                                    ArrayList<Integer> course_pointer = new ArrayList<>();
                                    for (int i = 0; i < semester_pointer.size(); i++) {
                                        if (Objects.equals(StudentEnrolmentManager.getAll().get(semester_pointer.get(i)).getCourseID(), c3)) {
                                            course_pointer.add(i);
                                        }
                                    }
                                    if (course_pointer.size() != 0) {
                                        for (int i = 0; i < course_pointer.size(); i++) {
                                            StudentEnrolmentManager.delete(course_pointer.get(i));
                                        }
                                    }
                                } else {
                                    System.out.println("*** No courses found! ***");
                                }
                            }
                        }
                        case "0" -> System.out.println("*** Returned to main menu! ***");
                        default -> System.out.println("*** That is not a valid option, please try again. ***");
                    }
                }

                case "4" -> {
                    String sub2;
                    do {
                        System.out.println("""
                                ***********************************************
                                PRINT
                                ***********************************************
                                1. Show all courses for a student in a semester
                                2. Show all students of a course in a semester
                                3. Show all courses offered in a semester
                                0. Back""");
                        System.out.print("Choose an option: ");
                        sub2 = sc.nextLine();
                        switch (sub2) {
                            case "1" -> System.out.println("1");
                            case "2" -> System.out.println("2");
                            case "3" -> System.out.println("3");
                            case "0" -> System.out.println("*** Returned to main menu! ***");
                            default -> System.out.println("*** That is not a valid option, please try again. ***");
                        }
                    } while (!sub2.equals("0"));
                }
                case "0" -> System.out.println("*** Thank you for using our system! ***");
                default -> System.out.println("*** That is not a valid option, please try again. ***");
            }
        } while(!main.equals("0"));
    }
}
