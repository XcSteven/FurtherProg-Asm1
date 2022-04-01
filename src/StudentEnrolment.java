import java.util.ArrayList;

public class StudentEnrolment {
    private Student student;
    private Course course;
    private String semester;
    private ArrayList<StudentEnrolment> enrolment_list;


    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public String getStudentID() {
        return student.getStudentID();
    }

    public String getStudentName() {
        return student.getStudentName();
    }

    public String getCourseID() {
        return course.getCourseID();
    }

    public String getCourseName() {
        return course.getCourseName();
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return "StudentEnrolment{" +
                "student=" + student +
                ", course=" + course +
                ", semester='" + semester + '\'' +
                ", enrolment_list=" + enrolment_list +
                '}';
    }
}
