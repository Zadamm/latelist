package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.domain.LateTime;
import de.jonashackt.springbootvuejs.util.LateTimeStatisticsDay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LateTimeRepository extends CrudRepository<LateTime, Long> {

    List<LateTime> findAll();

    @Query("SELECT "
            + " new de.jonashackt.springbootvuejs.util.LateTimeStatisticsDay(SUM(l.duration), l.dateOfLateTime)"
            + " FROM LateTime l "
            + " GROUP BY l.dateOfLateTime")
    List<LateTimeStatisticsDay> findAllGroupByDateOfLateTime();

}
