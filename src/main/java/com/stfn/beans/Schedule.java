package com.stfn.beans;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private int id;
    private int doctorId;
    private HashMap<DayOfWeek, TimeTable> schedules;

    public void addTimeTable(DayOfWeek dayOfWeek, LocalTime start, LocalTime end) {
        schedules.put(dayOfWeek, new TimeTable(start, end));
    }
    public void deleteTimeTable(DayOfWeek dayOfWeek){
        schedules.remove(dayOfWeek);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @RequiredArgsConstructor
    public class TimeTable {
        private int id;
        @NonNull
        private LocalTime timeStart;
        @NonNull
        private LocalTime timeEnd;
    }
}
