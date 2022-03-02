package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.AppointmentDAO;
import perscholas.database.dao.DoctorDAO;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.Appointment;
import perscholas.database.entity.User;
import perscholas.form.AppointmentFormBean;
import perscholas.form.RegisterFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private DoctorDAO doctorDAODao;

    @Autowired
    private AppointmentDAO appointmentDao;

    @RequestMapping(value = "/appointmentform", method = RequestMethod.GET)
    public ModelAndView appointmentform(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
       // response.setViewName("/appointment/appointments");
        response.setViewName("redirect:/doctors");
        return response;
    }

    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public ModelAndView appointments(@RequestParam String doctorname, @RequestParam Integer doctorid, HttpServletRequest request) throws Exception {
        ModelAndView response = new ModelAndView();
        response.addObject("docname", doctorname);
        response.setViewName("/appointment/appointments");
        Principal principal = request.getUserPrincipal();
        User user = userDao.findByUserName(principal.getName());
        response.addObject("patient_name", user.getFirstName() + " " + user.getLastName());
        response.addObject("patient_email", user.getEmail());
        response.addObject("patient_id", user.getId());
        response.addObject("phone_number", user.getPhoneNumber());
        response.addObject("doctor_id", doctorid);

        AppointmentFormBean form = new AppointmentFormBean();
        response.addObject("formBeanKey", form);

        return response;
    }

    @RequestMapping(value = "/appointmentSubmit", method = RequestMethod.GET)
    public ModelAndView appointmentSubmit(@Valid AppointmentFormBean form ) throws Exception {
//        System.out.println("appointment date :" +form.getApptDate() + form.getDoctorId()+form.getPatientId()) ;
        ModelAndView response = new ModelAndView();

         Appointment appointment=new Appointment();

         appointment.setId(form.getId());
         appointment.setApptDate(form.getApptDate());
         appointment.setApptTime(form.getApptTime());
         appointment.setStatus(form.getStatus());
         appointment.setPatient(userDao.findById(form.getPatientId()));
         appointment.setDoctor(doctorDAODao.findById(form.getDoctorId()));
         appointment.setMessage(form.getMessage());
         appointmentDao.save(appointment);

         response.addObject("appointmentdate", form.getApptDate());
         response.addObject("appointmenttime",form.getApptTime());

        response.setViewName("/appointment/appointmentSubmit");

        return response;
    }

    @RequestMapping(value = "/appointmentList", method = RequestMethod.GET)
    public ModelAndView appointmentList() throws Exception {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView response = new ModelAndView();
        response.setViewName("/appointment/appointmentList");

//        if (!StringUtils.isEmpty(search)) {
//            List<Appointment> appointments = appointmentDao.findAll();
            List<Appointment> appointments = appointmentDao.findAllByPatient(userDao.findByUserName(userName));
            response.addObject("appointmentListKey", appointments);
//            response.addObject("searchInput", search);
//        }

        return response;
    }


    @RequestMapping(value = "/cancelAppointment", method = RequestMethod.GET)
    public ModelAndView cancel(@RequestParam Integer id) throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/appointmentList");

        Appointment cancel= appointmentDao.findById(id);
        if(cancel !=null){
            cancel.setStatus("Cancelled");
            appointmentDao.save(cancel);

        }
        return response;
    }

}
