package com.keygenie.calendercrud;

import com.keygenie.calendercrud.entity.Plan;
import com.keygenie.calendercrud.repository.PlanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
public class PlanRepositoryTest {

    @Autowired
    private PlanRepository planRepository;

    //@Test
    public void insertPlans() {
        Random r = new Random();
        String[] colors = {"#dcced3", "#d1bec7", "#c7b0bc", "#876479", "#674559", "#4c3041"};

        IntStream.rangeClosed(1, 11).forEach(i -> {
            int priority = 1 + r.nextInt(5);
            int allDay = r.nextInt(2);
            int pDate = 10 + r.nextInt(16);
            int pHour = 10 + r.nextInt(12);
            int pMinute = 10 + r.nextInt(50);
            String textColor = "gray";
            String start = "2022-03-" + pDate + "T" + pHour + ":" + pMinute;
            String end = "2022-03-" + (pDate + priority) + "T" + pHour + ":" + pMinute;
            String backgroundColor = colors[priority - 1];
            String borderColor = colors[priority];
            if (allDay == 0) {
                end = "2022-03-" + pDate + "T" + (pHour + 1) + ":" + pMinute;;
            }
            if (priority > 2) {
                textColor = "white";
            }
            Plan plan = Plan.builder()
                    .title("Title_" + i)
                    .description("Description_" + i)
                    .location("Location_" + i)
                    .priority(priority)
                    .allDay(allDay)
                    .start(LocalDateTime.parse(start))
                    .end(LocalDateTime.parse(end))
                    .backgroundColor(backgroundColor)
                    .borderColor(borderColor)
                    .textColor(textColor)
                    .build();
            planRepository.save(plan);
        });
    }

    @Test
    public void LocalDateTimeParsingTest() {
        String date = "2022-03-01T00:00";
        System.out.println("date: " + date);
        LocalDateTime first = LocalDateTime.parse(date);
        System.out.println("first: " + first);
        date = first.toString();
        System.out.println("date: " + date);

    }
}
