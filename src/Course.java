public class Course {
    private String id;
    private String name;
    private int credit_num;

    public Course() {
        this.id = "s1234567";
        this.name = "default";
        this.credit_num = 1;
    }

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
}
