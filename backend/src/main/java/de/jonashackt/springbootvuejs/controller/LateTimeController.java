package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.LateTime;
import de.jonashackt.springbootvuejs.service.LateTimeService;
import de.jonashackt.springbootvuejs.util.LateTimeStatisticsDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/latetimes")
public class LateTimeController {

    @Autowired
    private LateTimeService lateTimeService;

    @GetMapping("/")
    public List<LateTime> findAll() {
        return lateTimeService.findAll();
    }

    @PostMapping("/")
    public void save(@RequestBody LateTime lateTime) {
        lateTimeService.save(lateTime);
    }

    @GetMapping("/groupByDate")
    public List<LateTimeStatisticsDay> findAllGroupByDate() {
        return lateTimeService.findAllGroupByDateOfLateTime();
    }
}
