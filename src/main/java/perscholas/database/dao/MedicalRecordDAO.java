package perscholas.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;;
import perscholas.database.entity.Appointment;
import perscholas.database.entity.MedicalRecord;
import perscholas.database.entity.User;


import java.util.List;

@Repository
public interface MedicalRecordDAO extends JpaRepository<MedicalRecord, Long> {

    public MedicalRecord findById(@Param("id") Integer id);
    public List<MedicalRecord> findByRecordTypeIgnoreCase(@Param("recordType") String recordType);

    @Query("select a from MedicalRecord a where a.patient = :userParam")
    public List<MedicalRecord> findAllByPatient(@Param("userParam") User user);

}
