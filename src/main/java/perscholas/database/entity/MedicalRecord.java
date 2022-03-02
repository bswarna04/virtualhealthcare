package perscholas.database.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "record_type")
    private String recordType;

    @Column(name = "file_name")
    private String fileName;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @Column(name = "date_uploaded")
    private Date dateUploaded;

    @ManyToOne(fetch = FetchType.LAZY)
    private User patient;
}
