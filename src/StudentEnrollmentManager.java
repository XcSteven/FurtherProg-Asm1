import java.util.ArrayList;

public interface StudentEnrollmentManager {
    ArrayList<StudentEnrolment> enrolment_list = new ArrayList<>();

    static void add(Student s, Course c, String sem) {
        StudentEnrolment new_enrolment = new StudentEnrolment(s, c, sem);
        enrolment_list.add(new_enrolment);
        System.out.println("Student " + s.getStudentName() + "has been enrolled into course " + c.getCourseName() + "in semester "  + sem);
    }

    void update();

    void delete();

    void getOne();

    void getAll();

}
