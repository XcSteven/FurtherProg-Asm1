import java.io.*;
import java.util.*;

public class Main implements StudentEnrolmentManager {
    static Set<Student> student_list = new HashSet<>();
    static Set<Course> course_list = new HashSet<>();
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
        for (Student student : student_list) {
            if (Objects.equals(student.getStudentID(), id)) {
                return student;
            }
        }
        return null;
    }

    public static Course courseFind(String id) {
        for (Course course : course_list) {
            if (Objects.equals(course.getCourseID(), id)) {
                return course;
            }
        }
        return null;
    }

    public static void allEnrolments() {
        for (int i = 0; i < StudentEnrolmentManager.getAll().size(); i++) {
            System.out.println(StudentEnrolmentManager.getAll().get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        String input;
        String csv_file;
        System.out.print("Choose a CSV file to read data from: ");
        input = sc.nextLine();
        if (Objects.equals(input, "")) {
            csv_file = "default.csv";
            System.out.println("*** No file was chosen, so default.csv is being read instead. ***");
        } else if (input.contains(".csv")) {
            csv_file = input;
        } else {
            csv_file = input + ".csv";
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
                    String s = sc.nextLine();
                    Student student = studentFind(s);
                    if (student != null) {
                        System.out.print("Enter the course ID: ");
                        String c = sc.nextLine();
                        Course course = courseFind(c);
                        if (course != null) {
                            System.out.print("Enter the semester to be enrolled in: ");
                            String sem = sc.nextLine();
                            StudentEnrolmentManager.add(student, course, sem);
                        } else {
                            System.out.println("*** No courses found! ***");
                        }
                    } else {
                        System.out.println("*** No students found! ***");
                    }
                }
                case "3" -> {
                    String sem;
                    ArrayList<Integer> semester_pointer = new ArrayList<>();
                    ArrayList<Integer> student_pointer = new ArrayList<>();
                    System.out.print("Enter the student ID: ");
                    String s = sc.nextLine();
                    for (int i = 0; i < StudentEnrolmentManager.getAll().size(); i++) {
                        if (Objects.equals(StudentEnrolmentManager.getAll().get(i).getStudentID(), s)) {
                            student_pointer.add(i);
                        }
                    }
                    if (student_pointer.size() != 0) {
                        System.out.print("Enter the semester: ");
                        sem = sc.nextLine();
                        for (int i = 0; i < student_pointer.size(); i++) {
                            if (Objects.equals(StudentEnrolmentManager.getAll().get(student_pointer.get(i)).getSemester(), sem)) {
                                semester_pointer.add(student_pointer.get(i));
                            }
                        }
                        if (semester_pointer.size() != 0) {
                            System.out.println("*** ENROLMENTS OF " + s + " IN SEMESTER " + sem + " ***");
                            for (int i = 0; i < semester_pointer.size(); i++) {
                                System.out.println(StudentEnrolmentManager.getAll().get(semester_pointer.get(i)));
                            }
                        } else {
                            System.out.println("*** That student is not enrolled in semester " + sem + ". ***");
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
                            Student student = studentFind(s);
                            if (student != null) {
                                System.out.print("Enter the course ID: ");
                                String c = sc.nextLine();
                                Course course = courseFind(c);
                                if (course != null) {
                                    System.out.println("1");
                                    StudentEnrolmentManager.add(student, course, sem);
                                } else {
                                    System.out.println("*** No courses found! ***");
                                }
                            }
                        }
                        case "2" -> {
                            Student student = studentFind(s);
                            if (student != null) {
                                System.out.print("Enter the course ID: ");
                                String c = sc.nextLine();
                                Course course = courseFind(c);
                                if (course != null) {
                                    ArrayList<Integer> course_pointer = new ArrayList<>();
                                    for (int i = 0; i < semester_pointer.size(); i++) {
                                        if (Objects.equals(StudentEnrolmentManager.getAll().get(semester_pointer.get(i)).getCourseID(), c)) {
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
                            case "1" -> {
                                ArrayList<Integer> semester_pointer = new ArrayList<>();
                                ArrayList<Integer> student_pointer = new ArrayList<>();
                                System.out.print("Enter the student ID: ");
                                String s = sc.nextLine();
                                for (int i = 0; i < StudentEnrolmentManager.getAll().size(); i++) {
                                    if (Objects.equals(StudentEnrolmentManager.getAll().get(i).getStudentID(), s)) {
                                        student_pointer.add(i);
                                    }
                                }
                                if (student_pointer.size() != 0) {
                                    System.out.print("Enter the semester: ");
                                    String sem = sc.nextLine();
                                    for (int i = 0; i < student_pointer.size(); i++) {
                                        if (Objects.equals(StudentEnrolmentManager.getAll().get(student_pointer.get(i)).getSemester(), sem)) {
                                            semester_pointer.add(student_pointer.get(i));
                                        }
                                    }
                                    if (semester_pointer.size() != 0) {
                                        Set<String> display = new HashSet<>();
                                        ArrayList<Course> course_display = new ArrayList<>();
                                        for (int i = 0; i < semester_pointer.size(); i++) {
                                            display.add(enrolment_list.get(semester_pointer.get(i)).getCourseID());
                                        }
                                        for (String i : display) {
                                            course_display.add(courseFind(i));
                                        }
                                        System.out.println("*** ALL COURSES OF " + s + " IN SEMESTER " + sem + " ***");
                                        for (int i = 0 ; i < course_display.size(); i++) {
                                            System.out.println(course_display.get(i));
                                            System.out.println("**************************************************");
                                        }
                                        File file_name = new File(Objects.requireNonNull(studentFind(s)).getStudentID()
                                                + "_" + sem + ".csv");
                                        FileWriter report = new FileWriter(file_name);
                                        for (Course c : course_display) {
                                            report.append(c.getCourseID()).append(",").append(c.getCourseName()).append(",").append(String.valueOf(c.getCourseCredit()));
                                            report.append('\n');
                                        }
                                        report.flush();
                                        report.close();
                                        System.out.println("*** " + file_name + " was saved. ***");
                                    } else {
                                        System.out.println("*** That student is not enrolled in semester " + sem + ". ***");
                                    }
                                } else {
                                    System.out.println("*** That student does not exist. ***");
                                }
                            }
                            case "2" -> {
                                ArrayList<Integer> semester_pointer = new ArrayList<>();
                                ArrayList<Integer> course_pointer = new ArrayList<>();
                                System.out.print("Enter the course ID: ");
                                String c = sc.nextLine();
                                for (int i = 0; i < StudentEnrolmentManager.getAll().size(); i++) {
                                    if (Objects.equals(StudentEnrolmentManager.getAll().get(i).getCourseID(), c)) {
                                        course_pointer.add(i);
                                    }
                                }
                                if (course_pointer.size() != 0) {
                                    System.out.print("Enter the semester: ");
                                    String sem = sc.nextLine();
                                    for (int i = 0; i < course_pointer.size(); i++) {
                                        if (Objects.equals(StudentEnrolmentManager.getAll().get(course_pointer.get(i)).getSemester(), sem)) {
                                            semester_pointer.add(course_pointer.get(i));
                                        }
                                    }
                                    if (semester_pointer.size() != 0) {
                                        Set<String> display = new HashSet<>();
                                        ArrayList<Student> student_display = new ArrayList<>();
                                        for (int i = 0; i < semester_pointer.size(); i++) {
                                            display.add(enrolment_list.get(semester_pointer.get(i)).getStudentID());
                                        }
                                        for (String i : display) {
                                            student_display.add(studentFind(i));
                                        }
                                        System.out.println("*** ALL STUDENTS OF " + c + " IN SEMESTER " + sem + " ***");
                                        for (int i = 0 ; i < student_display.size(); i++) {
                                            System.out.println(student_display.get(i));
                                            System.out.println("**************************************************");
                                        }
                                        File file_name = new File(Objects.requireNonNull(courseFind(c)).getCourseID()
                                                + "_" + sem + ".csv");
                                        FileWriter report = new FileWriter(file_name);
                                        for (Student s : student_display) {
                                            report.append(s.getStudentID()).append(",").append(s.getStudentName()).append(",").append(s.getStudentBirthdate());
                                            report.append('\n');
                                        }
                                        report.flush();
                                        report.close();
                                        System.out.println("*** " + file_name + " was saved. ***");
                                    } else {
                                        System.out.println("*** That course is not offered in semester " + sem + ". ***");
                                    }
                                } else {
                                    System.out.println("*** That course does not exist. ***");
                                }
                            }
                            case "3" -> {
                                System.out.print("Enter the semester: ");
                                String sem = sc.nextLine();
                                ArrayList<Integer> semester_pointer = new ArrayList<>();
                                for (int i = 0; i < enrolment_list.size(); i++) {
                                    if (Objects.equals(enrolment_list.get(i).getSemester(), sem)) {
                                        semester_pointer.add(i);
                                    }
                                }
                                if (semester_pointer.size() != 0) {
                                    Set<String> display = new HashSet<>();
                                    ArrayList<Course> course_display = new ArrayList<>();
                                    for (int i = 0; i < semester_pointer.size(); i++) {
                                        display.add(enrolment_list.get(semester_pointer.get(i)).getCourseID());
                                    }
                                    for (String i : display) {
                                        course_display.add(courseFind(i));
                                    }
                                    System.out.println("*** COURSES OFFERED IN SEMESTER " + sem + " ***");
                                    for (int i = 0 ; i < course_display.size(); i++) {
                                        System.out.println(course_display.get(i));
                                        System.out.println("*****************************************");
                                    }
                                    File file_name = new File(sem + "_ALL_COURSES.csv");
                                    FileWriter report = new FileWriter(file_name);
                                    for (Course c : course_display) {
                                        report.append(c.getCourseID()).append(",").append(c.getCourseName()).append(",").append(String.valueOf(c.getCourseCredit()));
                                        report.append('\n');
                                    }
                                    report.flush();
                                    report.close();
                                    System.out.println("*** " + file_name + " was saved. ***");
                                } else {
                                    System.out.println("*** Semester " + sem + " does not exist. ***");
                                }
                            }
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
