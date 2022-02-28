package gof.java.designpatterns.builder.after;

import gof.java.designpatterns.builder.before.TourPlan;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        TourPlanBuilder builder = new DefaultTourBuilder();
        TourPlan plan = builder.title("칸쿤 여행").nightsAndDays(2, 3)
                .startDate(LocalDate.of(2020, 12, 9))
                .whereToStay("리조트")
                .addPlan(0, "체크인 하고 짐 풀기")
                .addPlan(0, "저녁 식사")
                .getPlan();

        TourPlan longBeachTrip = builder.title("롱비치")
                .startDate(LocalDate.of(2021, 7, 15))
                .getPlan();

    }
}
