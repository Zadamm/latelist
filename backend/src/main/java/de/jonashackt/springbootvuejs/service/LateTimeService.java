package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.domain.LateTime;
import de.jonashackt.springbootvuejs.util.LateTimeStatisticsDay;

import java.util.List;

public interface LateTimeService {

    List<LateTime> findAll();

    LateTime save(LateTime lateTime);

    List<LateTimeStatisticsDay> findAllGroupByDateOfLateTime();
}
