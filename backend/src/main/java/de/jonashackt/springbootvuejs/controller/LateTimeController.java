package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.LateTime;
import de.jonashackt.springbootvuejs.repository.LateTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/latetime")
public class LateTimeController {

    @Autowired
    private LateTimeRepository lateTimeRepository;

    @GetMapping("/")
    public List<LateTime> findAll() {
        return lateTimeRepository.findAll();
    }
}
