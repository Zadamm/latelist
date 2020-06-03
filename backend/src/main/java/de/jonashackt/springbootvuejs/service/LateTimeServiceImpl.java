package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.domain.LateTime;
import de.jonashackt.springbootvuejs.repository.LateTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return lateTimeRepository.save(lateTime);
    }
}
