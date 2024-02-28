package hvorostina.example.studentapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

/*@Getter         //чтобы не прописывать геттеры & сеттеры
@Setter             //используем lombok maven
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor*/
@Data   //содержит все предыдущие + hashCode() + equals()
            // -> mvn repo -> lombok. Ctrl + Shift + O to change pom.xml
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dayOfBirth;
    @Column(unique = true)
    private String email;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(dayOfBirth, LocalDate.now()).getYears();
    }
}
