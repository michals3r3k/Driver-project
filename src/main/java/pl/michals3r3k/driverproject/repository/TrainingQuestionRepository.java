package pl.michals3r3k.driverproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michals3r3k.driverproject.entity.TrainingQuestion;

@Repository
public interface TrainingQuestionRepository extends JpaRepository<TrainingQuestion, Long> {
}
