package perscholas.controller;

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

    @Autowired
    private DoctorDAO doctorDao;


    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public ModelAndView doctors(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        List<Doctor> doctorList= doctorDao.findAll();
        response.addObject("doctor_list", doctorList);
        response.setViewName("/doctors");
        return response;
    }

}
