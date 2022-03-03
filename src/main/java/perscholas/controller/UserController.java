package perscholas.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.MedicalRecordDAO;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.MedicalRecord;
import perscholas.database.entity.User;

import java.io.File;
import java.util.Date;

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

        String tempdir = "C:\\Rekha\\MedicalRecords";
        File saveFileDirectory = new File(tempdir);
        if (! saveFileDirectory.exists() ) {
            log.debug("Creating temp folder for file upload : " + saveFileDirectory.getAbsolutePath());
            saveFileDirectory.mkdirs();
        }

        String saveFileName = saveFileDirectory.getAbsolutePath() + File.separator + file.getOriginalFilename();
        File targetFile = new File(saveFileName);

        if ( targetFile.exists() ) {
            throw new Exception("Unable to save uploaded file " + file.getOriginalFilename() + " because a file with that name already exists");
        }

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
