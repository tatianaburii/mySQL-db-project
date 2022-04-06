import java.sql.*;
import java.util.ArrayList;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/Student?"
                    + "user=root&password=rootroot");
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("SELECT id, first_name, last_name, coming_year from Student");
            resultSet = preparedStatement.executeQuery();
            getAllStudents(resultSet);
            deleteStudent(5);
            //  statement.execute("insert into  Student (id, first_name, last_name, coming_year) value  (94, 'Ivan', 'Ivanov', 2021)");
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public boolean deleteStudent(int id) throws SQLException {
        preparedStatement = connect.prepareStatement("DELETE FROM Student WHERE id=" + id);
        preparedStatement.executeUpdate();
        return true;
    }


    private void getMetaData(ResultSet resultSet) throws SQLException {
        System.out.println("The columns in the table are: ");
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column: " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private ArrayList<Student> getAllStudents(ResultSet resultSet) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            int coming_year = resultSet.getInt("coming_year");
            students.add(new Student(id, first_name, last_name, coming_year));
        }
        return students;
    }

    public ArrayList<Student> getById(ArrayList<Integer> ids) throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : getAllStudents(resultSet)) {
            if (ids.contains(student.id)) {
                students.add(student);
            }
        }
        return students;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }


}
