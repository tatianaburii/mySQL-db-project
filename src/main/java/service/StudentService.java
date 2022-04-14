package service;

import entity.Student;

import java.util.List;

public interface StudentService {
    Student findStudentById(int id);

    List<Student> findStudentByName(String name);

    void saveStudent(Student student);

    void deleteStudent(Student student);

    List<Student> findAllStudents();
}
