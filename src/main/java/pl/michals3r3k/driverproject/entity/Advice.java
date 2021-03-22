package pl.michals3r3k.driverproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Nullable
    private String attachedFile;
    private LocalDate dateOfPublic;
    private LocalTime timeOfPublic;
    @OneToMany
    private List<Question> questions;
}
