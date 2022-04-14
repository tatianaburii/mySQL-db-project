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
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "coming_year")
    private int comingYear;

    public Student(){}

    public Student(String first_name, String last_name, int coming_year) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.comingYear = coming_year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", coming_year=" + comingYear +
                '}';
    }
}
