import java.util.ArrayList;
import java.util.Objects;

public interface StudentEnrolmentManager {
    ArrayList<StudentEnrolment> enrolment_list = new ArrayList<>();

    static void add(Student s, Course c, String sem) {
        StudentEnrolment new_enrolment = new StudentEnrolment(s, c, sem);
        enrolment_list.add(new_enrolment);
        System.out.println("Student " + s.getStudentName() + " has been enrolled into course " + c.getCourseName() + " in semester "  + sem + ".");
    }

    void update();

    static void delete(String sID, String cID, String sem) {
        for (int i = 0; i < enrolment_list.size(); i++) {
            if (Objects.equals(enrolment_list.get(i).getStudentID(), sID)) {
                if (Objects.equals(enrolment_list.get(i).getCourseID(), cID)) {
                    if (Objects.equals(enrolment_list.get(i).getSemester(), sem)) {
                        enrolment_list.remove(i);
                        System.out.println("Enrolment deleted.");
                    } else {
                        System.out.println("Enrolment not found!");
                    }
                } else {
                    System.out.println("That student did not enroll in this course!");
                }
            } else {
                System.out.println("No students found!");
            }
        }
    }

    void getOne();

    static void getAll() {
        for (int i = 0; i < enrolment_list.size(); i++) {
            System.out.println(enrolment_list);
        }
    }

}
