package com.stfn.beans;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Schedule {
    private int id;
    @NonNull
    private int doctorId;
    private HashMap<DayOfWeek, Timetable> schedules;

    public void addTimeTable(DayOfWeek dayOfWeek, LocalTime start, LocalTime end) {
        schedules.put(dayOfWeek, new Timetable(start, end));
    }
    public void deleteTimeTable(DayOfWeek dayOfWeek){
        schedules.remove(dayOfWeek);
    }

}
