import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Main implements StudentEnrolmentManager {
    static ArrayList<Student> student_list = new ArrayList<>();
    static ArrayList<Course> course_list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void read(String csv_file) {
        try {
            File file = new File(csv_file);
            FileReader file_reader = new FileReader(file);
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            String row;
            while ((row = buffered_reader.readLine()) != null) {
                String[] element = row.split(",");
                student_list.add(new Student(element[0], element[1], element[2]));
                course_list.add(new Course(element[3], element[4], Integer.parseInt(element[5])));
                StudentEnrolmentManager.getAll().add(new StudentEnrolment(new Student(element[0], element[1], element[2]),
                        new Course(element[3], element[4], Integer.parseInt(element[5])), element[6]));
            }
        }
        catch(IOException e) {
            System.out.println("*** File " + csv_file + " not found! ***");
            System.exit(0);
        }
    }

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
        String csv_input;
        String csv_file;
        System.out.print("Choose a CSV file to read data from: ");
        csv_input = sc.nextLine();
        if (Objects.equals(csv_input, "")) {
            csv_file = "default.csv";
            System.out.println("*** No file was chosen, so default.csv is being read instead. ***");
        } else if (csv_input.contains(".csv")) {
            csv_file = csv_input;
        } else {
            csv_file = csv_input + ".csv";
        }
        read(csv_file);
        System.out.println("*** File " + csv_file + " is being read. ***");

        String main;
        do {
            System.out.println("""
                    **************************************************
                    Welcome to RMIT Student Enrolment Managing System!
                    **************************************************
                    1. Show all enrolments
                    2. Enrol a student
                    3. Update an enrolment
                    4. Display as desired
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
                    String sem2;
                    ArrayList<Integer> semester_pointer = new ArrayList<>();
                    System.out.print("Enter the student ID: ");
                    String s2 = sc.nextLine();
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
                                semester_pointer.add(student_pointer.get(i));
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
                            0. Back to main menu""");
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
                                    System.out.println("1");
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
                                            course_pointer.add(semester_pointer.get(i));
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
                                ******************
                                DISPLAY AS DESIRED
                                ******************
                                1. Display all courses for a student in a semester
                                2. Display all students of a course in a semester
                                3. Display all courses offered in a semester
                                0. Back to main menu""");
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
