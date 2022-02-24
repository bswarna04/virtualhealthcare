package perscholas.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import perscholas.database.entity.Doctor;

import java.util.List;

@Repository
public interface DoctorDAO extends JpaRepository<Doctor, Long> {

    public Doctor findById(@Param("id") Integer id);
    public Doctor findByEmail(@Param("email") String email);
    public List<Doctor> findByFirstName(@Param("firstName") String firstName);
    public List<Doctor> findByLastName(@Param("lastName") String lastName);
    public List<Doctor> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);
    public List<Doctor> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
