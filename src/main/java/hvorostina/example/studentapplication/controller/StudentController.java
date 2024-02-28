package hvorostina.example.studentapplication.controller;

import hvorostina.example.studentapplication.model.Student;
import hvorostina.example.studentapplication.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//  controller принимает запрос клиента
//      и вызывает соответствующую бизнес-логику
@RestController                 //контроллер для restful приложения
//содержит аннотацию @ResponseBody, которая применяется ко всем методам в контроллере
@RequestMapping ("/api/v1/students")    //принимает строку, обычно пишут api(для rest)/*версия*/*название приложение*
@AllArgsConstructor
public class StudentController {
    //  контроллер НЕ ДОЛЖЕН управлять жизненным циклом сервиса
    //@Autowired  //  для внедрения bean'а в контроллер (внедрение полем) -> устаревший!
    //  final -> как const, но определяется во время выполнения, а не компиляции
    //  dependency injection
    private final StudentService service;
    //  метод GET -- получение (чтение) данных с сервера
    //      потому и аннотация @GetMapping
    @GetMapping
    public List<Student> findAllStudent() {
        //todo
        return service.findAllStudent();
    }
    //  данный метод должен быть методом POST -- методом отправки данных на сервер
    //      потому и аннотация @PostMapping
    @PostMapping("save_student")    //@RequestBody сереализует запрашиваемый объект
    public String saveStudent(@RequestBody Student student) {
        service.saveStudent(student);
        return "Student saved!";
    }
    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }
    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }
    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email) {
        service.deleteStudent(email);
    }
}
