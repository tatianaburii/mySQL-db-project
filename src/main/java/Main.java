import serviceImpl.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        StudentServiceImpl service = new StudentServiceImpl();
//        Student student = new Student("James", "Bond", 2022);
//        Student student1 = new Student("Tetiana", "Burii", 2020);
//        service.saveStudent(student1);
//        for(Student st : service.findAllStudents()) {
//            System.out.println(st);
//        }
        System.out.println(service.findStudentByName("Tetiana"));
    }
}


