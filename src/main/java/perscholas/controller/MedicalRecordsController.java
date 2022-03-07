package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.MedicalRecordDAO;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.MedicalRecord;

import java.util.List;

@Controller
public class MedicalRecordsController {

    @Autowired
    private MedicalRecordDAO medicalRecordDao;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/viewrecords", method = RequestMethod.GET)
    public ModelAndView viewrecords(@RequestParam Integer editRecID) throws Exception {
        ModelAndView response = new ModelAndView();
        List<MedicalRecord> medicalRecords;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            medicalRecords = medicalRecordDao.findAll();
        } else {
            medicalRecords = medicalRecordDao.findAllByPatient(userDAO.findByUserName(auth.getName()));
        }

        response.setViewName("/user/medicalRecords");
        response.addObject("recordsKey", medicalRecords);
        response.addObject("editRecID",editRecID);
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

        response.setViewName("redirect:/viewrecords?editRecID=0");
        MedicalRecord delete= medicalRecordDao.findById(id);
        if(delete !=null){
            medicalRecordDao.delete(delete);
        }
        return response;
    }

    @RequestMapping(value = "/saveRecord", method = RequestMethod.GET)
    public ModelAndView editRecord(@RequestParam Integer editID, @RequestParam String recordType) throws Exception {

        ModelAndView response = new ModelAndView();
        MedicalRecord editRecord = medicalRecordDao.findById(editID);
        editRecord.setRecordType(recordType);
        if(editRecord !=null){
            medicalRecordDao.save(editRecord);
        }
        response.setViewName("redirect:/viewrecords?editRecID=0");

        return response;
    }
}
