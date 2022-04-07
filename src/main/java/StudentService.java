import java.sql.*;
import java.util.ArrayList;

import static org.hibernate.resource.jdbc.internal.ResourceRegistryStandardImpl.close;

public class StudentService {
    private static final String SQL_INSERT = "INSERT INTO Student (id, first_name, last_name, coming_year) VALUES(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM Student WHERE id = ?";
    private static final String SQL_SELECT = "SELECT id, first_name, last_name, coming_year FROM Student";
    Connection connect;

    public StudentService() throws SQLException {
        connect = ConnectorDB.getConnection();
    }


    public boolean addStudent(Student student) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_INSERT);
            ps.setInt(1, student.id);
            ps.setString(2, student.first_name);
            ps.setString(3, student.last_name);
            ps.setInt(4, student.coming_year);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(int id){
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Student> getByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : getAll()) {
            if (student.first_name.equals(name)) {
                students.add(student);
            }
        }
        return students;
    }


    ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int coming_year = resultSet.getInt("coming_year");
                students.add(new Student(id, first_name, last_name, coming_year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }
        return students;
    }

    public ArrayList<Student> getById(ArrayList<Integer> ids) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : getAll()) {
            if (ids.contains(student.id)) {
                students.add(student);
            }
        }
        return students;
    }


}
