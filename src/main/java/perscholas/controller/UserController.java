package perscholas.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.AppointmentDAO;
import perscholas.database.dao.MedicalRecordDAO;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.Appointment;
import perscholas.database.entity.MedicalRecord;
import perscholas.database.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class UserController {

    @Autowired
    private MedicalRecordDAO medicalRecordDao;

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/user/fileUpload", method = RequestMethod.GET)
    public ModelAndView upload() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/fileUpload");
        return response;
    }

    @RequestMapping(value = "/user/fileUploadSubmit", method = RequestMethod.POST)
    public ModelAndView uploadSubmit(@RequestParam MultipartFile file, @RequestParam(required = false) String recordType) throws Exception {

        MedicalRecord medicalrecord = new MedicalRecord();

        // figure out what the default OS temp directory is
        String tempdir = System.getProperty("java.io.tmpdir") + File.separator + "perscholas";

        // create a new file object for this directory and see if the directory exists
        File saveFileDirectory = new File(tempdir);
        if (! saveFileDirectory.exists() ) {
            // it does not exist so make the temp directory using mkdirs
            // mkdirs will create any parent folders needed
            log.debug("Creating temp folder for file upload : " + saveFileDirectory.getAbsolutePath());
            saveFileDirectory.mkdirs();
        }

        // build the full path to file we want to save
        String saveFileName = saveFileDirectory.getAbsolutePath() + File.separator + file.getOriginalFilename();
        File targetFile = new File(saveFileName);

        if ( targetFile.exists() ) {
            throw new Exception("Unable to save uploaded file " + file.getOriginalFilename() + " because a file with that name already exists");
        }
        // save the uploaded file to the hard drive using commons io
        // this will take the uploaded file stream and write it to the target file on the disk
        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);

        log.debug("Uploaded file saved to : " + targetFile.getAbsolutePath());
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User patient = userDao.findByUserName(userName);

        medicalrecord.setRecordType(recordType);
        medicalrecord.setDateUploaded(new Date());
        medicalrecord.setFileName(saveFileName);
        medicalrecord.setPatient(patient);
        medicalRecordDao.save(medicalrecord);

        ModelAndView response = new ModelAndView();
        response.setViewName("user/fileUpload");
        return response;
    }


}
