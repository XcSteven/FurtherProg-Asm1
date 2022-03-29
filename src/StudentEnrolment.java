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
        enrolment_list = new ArrayList<StudentEnrolment>();
    }
    
    public void addEnrollment(StudentEnrolment enrolment) {
        enrolment_list.add(enrolment);
    }
}
