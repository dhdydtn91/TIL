package me.water.demoinfleanrestapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {
    public void validate(EventDto eventDto, Errors errors){
        if (eventDto.getBasePrice() > eventDto.getMaxPrice()&& eventDto.getMaxPrice()!=0) {
            errors.rejectValue("basePrice","wrongValue" , "BasePrice is Wrong");
            errors.rejectValue("maxPrice","wrongValue" , "maxPrice is Wrong");
        }
        // endEventDateTime
        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if (endEventDateTime.isBefore(eventDto.getEndEventDateTime()) ||
        endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
        endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
            errors.rejectValue("endEventDateTime", "wrongValue");
        }

        //beginEnrollmentDateTime
        LocalDateTime beginEnrollmentDateTime = eventDto.getBeginEnrollmentDateTime();
        if(beginEnrollmentDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
        beginEnrollmentDateTime.isAfter(eventDto.getEndEventDateTime()) ||
        beginEnrollmentDateTime.isAfter(eventDto.getCloseEnrollmentDateTime())){
            errors.rejectValue("beginEnrollmentDateTime", "wrongValue");
        }

        // beginEventDateTime
        LocalDateTime beginEventDateTime =eventDto.getBeginEventDateTime();
        if(beginEventDateTime.isAfter(eventDto.getEndEventDateTime())||
         beginEventDateTime.isAfter(eventDto.getBeginEnrollmentDateTime())||
         beginEventDateTime.isAfter(eventDto.getCloseEnrollmentDateTime())){
            errors.rejectValue("beginEventDateTime", "wrongValue");
        }

        // closeEnrollmentDateTime
        LocalDateTime closeEnrollmentDateTime = eventDto.getCloseEnrollmentDateTime();
        if (closeEnrollmentDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
                closeEnrollmentDateTime.isBefore(eventDto.getBeginEnrollmentDateTime()) ||
                closeEnrollmentDateTime.isAfter(eventDto.getEndEventDateTime())) {
            errors.rejectValue("closeEnrollmentDateTime", "wrongValue");
        }

    }
}
