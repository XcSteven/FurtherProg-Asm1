public class StudentEnrolment {
    private Student student;
    private Course course;
    private String semester;

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

    public String getStudentBirthdate() {
        return student.getStudentBirthdate();
    }

    public String getCourseID() {
        return course.getCourseID();
    }

    public String getCourseName() {
        return course.getCourseName();
    }

    public int getCourseCredit() {
        return course.getCourseCredit();
    }

    public String getSemester() {
        return semester;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return getStudentID() + " " + getStudentName() + " " + getStudentBirthdate() + " " + getCourseID() + " " + getCourseName() + " " + getCourseCredit() + " " + getSemester();
    }
}
