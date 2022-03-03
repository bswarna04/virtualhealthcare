package perscholas.database.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import perscholas.database.entity.User;
import perscholas.database.entity.UserRole;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserDAOTest {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Test
    @Order(1)
    public void getPatientTest() {
        User user = userDao.findById(1);
        Assertions.assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void getListOfPatients() {
        List<User> users = userDao.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void savePatientTest() {

        User user = new User();
        user.setUsername("JUnitTester1");
        user.setFirstName("JUnit");
        user.setLastName("Tester");
        user.setDateOfBirth(new Date());
        user.setPhoneNumber("7777777777");
        user.setPassword("perscholas");
        userDao.save(user);
        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updatePatientEmailTest() {
        User user = userDao.findById(1);
        user.setEmail("adoum1@gmail.com");
        userDao.save(user);
        Assertions.assertThat(userDao.findById(1).getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deletePatientTest() {
        List<UserRole> userroles = userRoleDao.getUserRoles(65);
        for (UserRole ur: userroles) {
            userRoleDao.delete(ur);
        }

        User user = userDao.findById(65);
        userDao.delete(user);
        Optional<User> optionalUser = Optional.ofNullable(userDao.findById(user.getId()));

        User tempUser = null;
        if (optionalUser.isPresent()) {
            tempUser = optionalUser.get();
        }

        Assertions.assertThat(tempUser).isNull();
    }

}
