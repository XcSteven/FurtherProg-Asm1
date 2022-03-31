import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private String birthdate;
    private List<Student> student_list = new ArrayList<>();

    public Student(String id, String name, String birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getStudentID() {
        return id;
    }

    public String getStudentName() {
        return name;
    }

    public String getStudentBirthdate() {
        return birthdate;
    }

    public List<Student> getList() {
        return student_list;
    }

    public void getAllStudents() {
        for (Student student : student_list) {
            System.out.println(student.toString());
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
