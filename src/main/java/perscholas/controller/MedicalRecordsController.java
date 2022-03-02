package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.MedicalRecordDAO;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.Appointment;
import perscholas.database.entity.MedicalRecord;
import perscholas.database.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MedicalRecordsController {

    @Autowired
    private MedicalRecordDAO medicalRecordDao;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/viewrecords", method = RequestMethod.GET)
    public ModelAndView viewrecords(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<MedicalRecord> medicalRecords = medicalRecordDao.findAllByPatient(userDAO.findByUserName(userName));
        response.setViewName("/user/medicalRecords");
        response.addObject("recordsKey", medicalRecords);
        return response;
    }

    @RequestMapping(value = "/medicalRecords", method = RequestMethod.GET)
    public ModelAndView medicalRecords(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/medicalRecords");

        if (!StringUtils.isEmpty(search)) {
            List<MedicalRecord> records = medicalRecordDao.findByRecordTypeIgnoreCase(search);
            response.addObject("recordsKey", records);
            response.addObject("searchInput", search);
        }


        return response;
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam Integer id) throws Exception {

        ModelAndView response = new ModelAndView();
        //  response.setViewName("redirect:/registration-url-path/userList");
        response.setViewName("redirect:/viewrecords");
        MedicalRecord delete= medicalRecordDao.findById(id);
        if(delete !=null){
            medicalRecordDao.delete(delete);
        }
        return response;
    }
}
