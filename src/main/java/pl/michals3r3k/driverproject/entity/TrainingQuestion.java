package pl.michals3r3k.driverproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class TrainingQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private LocalDate dateOfPublic;
    private LocalTime timeOfPublic;
    @OneToMany
    @JoinTable(name = "question_answer")
    private List<Answer> questionAnswers;
}
