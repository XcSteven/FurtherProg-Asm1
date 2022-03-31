import java.util.ArrayList;

public class StudentEnrolment implements StudentEnrollmentManager {
    private Student student;
    private Course course;
    private String semester;
    private ArrayList<StudentEnrolment> enrolment_list;


    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public StudentEnrolment() {
        enrolment_list = new ArrayList<>();
    }

    public void addEnrolment(StudentEnrolment enrolment) {
        enrolment_list.add(enrolment);
    }

    public void updateEnrollment(StudentEnrolment enrolment) {

    }

    public void deleteEnrollment(StudentEnrolment enrolment) {

    }

    public void getOneEnrolment(StudentEnrolment enrolment) {

    }

    public void getAllEnrolment() {
        for (StudentEnrolment enrolment : enrolment_list) {
            System.out.println(enrolment.toString());
        }
    }
}
