package gof.java.designpatterns.creational_patterns.builder.after;

import gof.java.designpatterns.creational_patterns.builder.before.DetailPlan;
import gof.java.designpatterns.creational_patterns.builder.before.TourPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefaultTourBuilder implements TourPlanBuilder {

    private String title;

    private int nights;

    private int days;

    private LocalDate startDate;

    private String whereToStay;

    private List<DetailPlan> plans;


    @Override
    public TourPlanBuilder title(String title) {
        this.title = title;
        return this;
    }

    @Override
    public TourPlanBuilder nightsAndDays(int nights, int days) {
        this.nights = nights;
        this.days = days;
        return this;
    }

    @Override
    public TourPlanBuilder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public TourPlanBuilder whereToStay(String whereToStay) {
        this.whereToStay= whereToStay;
        return this;
    }

    @Override
    public TourPlanBuilder addPlan(int days, String plan) {
        if(this.plans == null){
            this.plans = new ArrayList<>();
        }
        this.plans.add(new DetailPlan(days,plan));
        return this;
    }

    @Override
    public TourPlan getPlan() {
        return new TourPlan(title,nights,days,startDate,whereToStay,plans);
    }
}
