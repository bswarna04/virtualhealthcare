package perscholas.database.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import perscholas.database.entity.MedicalRecord;

import java.util.List;

@SpringBootTest
public class MedicalRecordDAOTest {

    @Autowired
    private MedicalRecordDAO medicalRecordDao;

    @Test
    @Order(1)
    public void getListOfMedicalRecords() {
        List<MedicalRecord> medrecs = medicalRecordDao.findAll();
        Assertions.assertThat(medrecs.size()).isGreaterThan(0);
    }
}
