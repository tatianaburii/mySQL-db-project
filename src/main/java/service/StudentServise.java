package service;

import dao.StudentDao;
import entity.Student;

import java.util.List;

public class StudentServise {
    private StudentDao studentDao = new StudentDao();
    public StudentServise(){
    }
    public Student findStudentById(int id){
        return studentDao.findById(id);
    }
    public List<Student> findStudentByName(String name){
        return studentDao.findByName(name);
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
