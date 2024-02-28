package hvorostina.example.studentapplication.service;

import hvorostina.example.studentapplication.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

//  service должен быть ИНТЕРФЕЙСОМ, не классом
//  от него соответственно наследуются отдельные сервисы
public interface StudentService {
    List<Student> findAllStudent();
    Student saveStudent(Student student);
    Student findByEmail(String email);
    Student updateStudent(Student student);
    void deleteStudent(String email);
}
