package hvorostina.example.studentapplication.repository;

import hvorostina.example.studentapplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    void deleteByEmail(String email);
    Student findStudentByEmail(String email);
}
