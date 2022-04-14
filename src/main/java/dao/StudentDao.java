package dao;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public Student findById(int id) {
        return (Student) HibernateUtil.getSessionFactory().openSession().get(Student.class, id);
    }

    public List<Student> findByName(String name) {
        List<Student> students = new ArrayList<>();
        for (Student student : findAll()) {
            if (student.getFirst_name().equals(name)) {
                students.add(student);
            }
        }
        return students;
    }

    public void save(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

    public List<Student> findAll() {
        return (List<Student>) HibernateUtil.getSessionFactory().openSession().createQuery("From Student").list();
    }
}
