package perscholas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.DoctorDAO;
import perscholas.database.entity.Doctor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DoctorsController {

    public static final Logger LOG = LoggerFactory.getLogger(DoctorsController.class);

    @Autowired
    private DoctorDAO doctorDao;

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public ModelAndView doctors(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        List<Doctor> doctorList= doctorDao.findAll();
        response.addObject("doctor_list", doctorList);
        response.setViewName("/doctors");

        //Lambda to print the list of doctors in console

        doctorList.forEach( (n) -> {
            LOG.info(String.valueOf(n));

        });

        return response;
    }

}
