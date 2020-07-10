package me.water.demoinfleanrestapi.events;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder @NoArgsConstructor @AllArgsConstructor
@Data
public class EventDto {
    //입력값을 제한할 컬럼을 제외하고 DTO로 만든다.
    //기본 Event엔티티에 적용하기엔 너무 많은 애노테이션으로 코드가 복잡해 질수 있으므로 DTO로 분리하는것이 좋음.
    //Event와 동일한 컬럼을 받기 떄문에 코드중복이 생김
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotNull
    private LocalDateTime beginEnrollmentDateTime;
    @NotNull
    private LocalDateTime closeEnrollmentDateTime;
    @NotNull
    private LocalDateTime beginEventDateTime;
    @NotNull
    private LocalDateTime endEventDateTime;
    private String location; // (optional)이게 없으면 온라인 모임
    @Min(0)
    private int basePrice; // (optional)
    @Min(0)
    private int maxPrice; // (optional)
    @Min(0)
    private int limitOfEnrollment;
}
