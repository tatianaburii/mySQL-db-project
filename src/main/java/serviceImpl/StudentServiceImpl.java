package serviceImpl;

import dao.StudentDao;
import entity.Student;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDao();

    public StudentServiceImpl(){
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
