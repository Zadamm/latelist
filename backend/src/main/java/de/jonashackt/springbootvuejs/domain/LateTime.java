package de.jonashackt.springbootvuejs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="late_times")
public class LateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String name;

    Integer duration;

    @JsonFormat(pattern="yyyy-MM-dd")
    Date dateOfLateTime;

    public LateTime(String name, Integer duration, Date dateOfLateTime) {
        this.name = name;
        this.duration = duration;
        this.dateOfLateTime = dateOfLateTime;
    }

}
