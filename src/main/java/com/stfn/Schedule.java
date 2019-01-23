package com.stfn;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private static Map<DayOfWeek, String> s = new HashMap<>();

    public static void main(String[] args) {
        LocalTime start = LocalTime.of(9,0);
        LocalTime end = LocalTime.of(15,0);
        s.put(DayOfWeek.MONDAY, "09:00 - 15:00");
    }
}
