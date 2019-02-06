package com.stfn.beans;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Timetable {
    private int id;
    @NonNull
    private LocalTime timeStart;
    @NonNull
    private LocalTime timeEnd;
}
