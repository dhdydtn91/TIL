package me.water.demoinfleanrestapi.events;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @EqualsAndHashCode(of = "id")
@Builder @AllArgsConstructor @NoArgsConstructor
@Entity
public class Event {

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional)이게 없으면 온라인 모임
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus = EventStatus.DRAFT;

    public void update() {
        //Update
        if(this.basePrice == 0 && this.maxPrice == 0){
            this.free = true;
        } else {
            this.free = false;
        }
        //Update offline
        if (this.location == null || this.location.isBlank()) {  //isBlank() 공백을 빈값으로 처리 isEmpty와는 " " false 처리하는 차이가있음
            this.offline = false;
        }else{
            this.offline = true;
        }
    }
}
