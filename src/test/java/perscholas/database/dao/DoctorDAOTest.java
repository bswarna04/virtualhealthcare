package perscholas.database.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perscholas.database.entity.Doctor;


import java.util.List;

@SpringBootTest
public class DoctorDAOTest {

    @Autowired
    private DoctorDAO doctorDao;

    @Test
    @Order(1)
    public void getDoctorTest() {
        Doctor doctor = doctorDao.findById(1);
        Assertions.assertThat(doctor.getId()).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void getListOfDoctors() {
        List<Doctor> doctors = doctorDao.findAll();
        Assertions.assertThat(doctors.size()).isGreaterThan(0);
    }
}
