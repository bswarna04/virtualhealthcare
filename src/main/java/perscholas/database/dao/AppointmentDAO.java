package perscholas.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import perscholas.database.entity.Appointment;
import perscholas.database.entity.Doctor;
import perscholas.database.entity.User;

import java.util.List;

@Repository
public interface AppointmentDAO extends JpaRepository<Appointment, Long>{

    public Appointment findById(@Param("id") Integer id);

    public List<Appointment> findByStatus(@Param("firstName") String firstName);
    public List<Appointment> findByApptDate(@Param("appointmentDate") String apptDate);

    @Query("select a from Appointment a where a.patient = :userParam")
    public List<Appointment> findAllByPatient(@Param("userParam") User user);

}
