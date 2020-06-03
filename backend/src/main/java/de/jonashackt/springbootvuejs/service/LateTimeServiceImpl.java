package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.domain.LateTime;
import de.jonashackt.springbootvuejs.repository.LateTimeRepository;
import de.jonashackt.springbootvuejs.util.LateTimeStatisticsDay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LateTimeServiceImpl implements LateTimeService {

    @Autowired
    private LateTimeRepository lateTimeRepository;

    @Override
    public List<LateTime> findAll() {
        return lateTimeRepository.findAll();
    }

    @Override
    public LateTime save(LateTime lateTime) {
        log.info("lateTime date: " + lateTime.getDateOfLateTime());
        return lateTimeRepository.save(lateTime);
    }

    @Override
    public List<LateTimeStatisticsDay> findAllGroupByDateOfLateTime() {
        return lateTimeRepository.findAllGroupByDateOfLateTime();
    }
}
