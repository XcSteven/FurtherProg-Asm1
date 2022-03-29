import java.util.*;

public class Course {
    private String id;
    private String name;
    private int credit_num;
    private List<Course> course_list = new ArrayList<>();

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

    public int getCourseCredit() {
        return credit_num;
    }

    public List<Course> getCourseList() {
        return course_list;
    }

    public void addCourse(Course course) {
        course_list.add(course);
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

    public void getAllCourses() {
        for (Course course : course_list) {
            System.out.println(course.toString());
        }
    }
}
