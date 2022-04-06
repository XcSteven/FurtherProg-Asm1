public class Course {
    private String id;
    int identifier;
    private String name;
    private int credit_num;

    public Course(String id, String name, int credit_num) {
        this.id = id;
        this.name = name;
        this.credit_num = credit_num;
        this.identifier = Integer.parseInt(id.replaceAll("[a-zA-Z]", ""));
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

    @Override
    public int hashCode() {
        return identifier;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        return identifier == other.identifier;
    }

    @Override
    public String toString() {
        return "Course ID: " + id + "\n" + "Course name: " + name + "\n" + "Course credit: " + credit_num;
    }
}
