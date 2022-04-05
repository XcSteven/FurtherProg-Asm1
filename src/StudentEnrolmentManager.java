import java.util.ArrayList;
import java.util.Objects;

public interface StudentEnrolmentManager {
    ArrayList<StudentEnrolment> enrolment_list = new ArrayList<>();

    static void add(Student s, Course c, String sem) {
        StudentEnrolment new_enrolment = new StudentEnrolment(s, c, sem);
        enrolment_list.add(new_enrolment);
        System.out.println("*** Student " + s.getStudentName() + " has been enrolled into course " +
                c.getCourseName() + " in semester "  + sem + ". ***");
    }

    static void update(Student s, Course c, String sem) {
        for (int i = 0; i < enrolment_list.size(); i++) {
            if (Objects.equals(enrolment_list.get(i).getStudentID(), s.getStudentID())) {
                if (Objects.equals(enrolment_list.get(i).getCourseID(), c.getCourseID())) {
                    if (Objects.equals(enrolment_list.get(i).getSemester(), sem)) {
                        enrolment_list.get(i).setStudent(s);
                        enrolment_list.get(i).setCourse(c);
                        enrolment_list.get(i).setSemester(sem);
                    }
                }
            }
        }
    }

    static void delete(int pos) {
        enrolment_list.remove(pos);
        System.out.println("*** Enrollment deleted! ***");
    }

    static StudentEnrolment getOne(int pos) {
        return enrolment_list.get(pos);
    }

    static ArrayList<StudentEnrolment> getAll() {
        return enrolment_list;
    }

}
