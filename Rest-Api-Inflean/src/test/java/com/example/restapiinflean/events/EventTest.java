package com.example.restapiinflean.events;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    void builder() {
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    void javaBean() {
        // Given
        String name = "Event";
        String description = "Spring";

        //When
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        //Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
    void testFree() {
        //given
        Event event = Event.builder()
                .basePrice(0)
                .maxPrice(0)
                .build();

        //when
        event.update();

        //Then
        assertThat(event.isFree()).isTrue();

        //given
        Event event2 = Event.builder()
                .basePrice(100)
                .maxPrice(0)
                .build();
        //when
        event2.update();

        //Then
        assertThat(event2.isFree()).isFalse();

        //given
        Event event3 = Event.builder()
                .basePrice(0)
                .maxPrice(100)
                .build();
        //when
        event3.update();

        //Then
        assertThat(event3.isFree()).isFalse();

    }

    @Test
    void testOffline() {
        //Given
        Event event = Event.builder()
                .location("강남역 네이버 D2 스타텁 팩토리")
                .build();

        //When
        event.update();

        //Then
        assertThat(event.isOffline()).isTrue();

        //Given
        Event event2 = Event.builder()
                .build();

        //When
        event2.update();

        //Then
        assertThat(event2.isOffline()).isFalse();
    }
}