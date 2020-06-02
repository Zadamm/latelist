package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.domain.LateTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LateTimeRepository extends CrudRepository<LateTime, Long> {

    List<LateTime> findAll();
}
