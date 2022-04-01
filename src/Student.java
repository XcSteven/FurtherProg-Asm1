import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private String birthdate;

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

    @Override
    public String toString() {
        return "Student {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
