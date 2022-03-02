package perscholas.database.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "appt_date")
    private Date apptDate;

    @Column(name = "appt_time")
    private String apptTime;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @Column(name = "message")
    private String message ;


}
