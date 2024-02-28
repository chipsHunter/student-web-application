package hvorostina.example.studentapplication.service.Impl;

import hvorostina.example.studentapplication.model.Student;
import hvorostina.example.studentapplication.repository.InMemoryStudentDAO;
import hvorostina.example.studentapplication.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
//  сервис использует слой DAO для работы с данными в памяти
@Service    //  отдельный сервис для студентов, содержащихся в памяти
@AllArgsConstructor
public class InMemoryStudentServiceImpl implements StudentService {
    private final InMemoryStudentDAO repository;
    @Override
    public List<Student> findAllStudent() {
        return repository.findAllStudent();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email);
    }
}
