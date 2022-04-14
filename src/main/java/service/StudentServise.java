package service;

import dao.StudentDao;
import entity.Student;

import java.util.List;

public class StudentServise {
    private StudentDao studentDao = new StudentDao();
    public StudentServise(){
    }
    public Student findStudent(int id){
        return studentDao.findById(id);
    }
    public void saveStudent(Student student){
        studentDao.save(student);
    }
    public void deleteStudent(Student student){
        studentDao.delete(student);
    }
    public List<Student> findAllStudents(){
        return studentDao.findAll();
    }

}
