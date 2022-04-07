

public class Student {

    int id;
    String first_name;
    String last_name;
    String group_id;
    int coming_year;

    public Student( int id, String first_name, String last_name, int coming_year) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.coming_year = coming_year;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student[" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", group_id='" + group_id + '\'' +
                ", coming_year=" + coming_year +
                ']';
    }
}
