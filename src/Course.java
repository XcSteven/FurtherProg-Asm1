import java.util.*;

public class Course {
    private String id;
    private String name;
    private int credit_num;

    public Course(String id, String name, int credit_num) {
        this.id = id;
        this.name = name;
        this.credit_num = credit_num;
    }

    public String getCourseID() {
        return id;
    }

    public String getCourseName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", credit_num=" + credit_num +
                ", course_list=" + course_list +
                '}';
    }
}