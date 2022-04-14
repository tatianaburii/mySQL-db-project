package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "coming_year")
    private int coming_year;

    public Student(){}

    public Student(String first_name, String last_name, int coming_year) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.coming_year = coming_year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", coming_year=" + coming_year +
                '}';
    }
}
