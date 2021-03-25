package pl.michals3r3k.driverproject.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
public class AdviceResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDate dateOfPublic;
    private LocalTime timeOfPublic;

}
