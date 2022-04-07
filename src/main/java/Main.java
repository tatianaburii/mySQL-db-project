
public class Main {

    public static void main(String[] args) throws Exception {
        StudentService service = new StudentService();
//        for(Student student : service.getAll()){
//            System.out.println(student.toString());
//        }
//        for(Student student : service.getByName("Vasyl")){
//            System.out.println(student.toString());
//        }
        service.deleteStudent(77);
    }
}
