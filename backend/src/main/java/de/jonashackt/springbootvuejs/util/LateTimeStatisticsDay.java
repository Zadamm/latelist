package de.jonashackt.springbootvuejs.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class LateTimeStatisticsDay {

    private long durationSum;
    private Date date;

}
