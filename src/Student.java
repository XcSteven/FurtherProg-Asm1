public class Student {
    private String id;
    int identifier;
    private String name;
    private String birthdate;

    public Student(String id, String name, String birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.identifier = Integer.parseInt(id.replaceAll("S", ""));
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
        Student other = (Student) obj;
        return identifier == other.identifier;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + "\n" + "Student name: " + name + "\n" + "Birthdate: " + birthdate;
    }
}
