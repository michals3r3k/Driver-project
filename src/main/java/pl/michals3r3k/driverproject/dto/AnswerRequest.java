package pl.michals3r3k.driverproject.dto;

import lombok.Data;

@Data
public class AnswerRequest {
    private Long adviceId;
    private Long questionId;
    private Long answerId;
}
