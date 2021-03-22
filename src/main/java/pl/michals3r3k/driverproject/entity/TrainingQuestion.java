package pl.michals3r3k.driverproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

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
}
